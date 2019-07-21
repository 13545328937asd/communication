package com.wzx.gateway;

import com.wzx.Config.CommunicationConf;
import com.wzx.Voluble;
import com.wzx.exceptions.RemoteObjectNotFoundException;
import com.wzx.loadbalance.LoadBalance;
import com.wzx.loadbalance.RandomLoadBalance;
import com.wzx.message.CommunicationMessage;
import com.wzx.networking.NettyCommunicationClient;
import com.wzx.networking.NettyCommunnicationServer;
import com.wzx.networking.ObjectCommunicationClient;
import com.wzx.networking.ObjectCommunicationServer;
import com.wzx.objectlocation.LocationManager;
import com.wzx.objectlocation.LocationObserver;
import com.wzx.objectlocation.ZookeeperLocationManager;
import com.wzx.objectlocation.ZookeeperLocationObserver;
import com.wzx.serialize.FastJsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@Component("messageGateWay")
public class DefaultMessageGateWay implements  MessageGateWay, Voluble {
    private static Logger logger= LoggerFactory.getLogger(DefaultMessageGateWay.class);
    private LocationManager locationManager;
    private LocationObserver locationObserver;
    private LoadBalance loadBalance;
    private Map<String, ObjectCommunicationClient> clients=new HashMap<String, ObjectCommunicationClient>();
    private ObjectCommunicationServer server;
    ConcurrentHashMap<String, List<String>> locationTable=new ConcurrentHashMap<>();
    @PostConstruct
    public void init() throws InterruptedException {
        locationObserver=getLocationObserver(locationTable);
        locationManager=getLocationManager();
        loadBalance=getLoadBalance();
        server=getObjectCommunicationServer();
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    server.startServer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
        //server.startServer();
        locationObserver.startObserve();
    }

    private ObjectCommunicationServer getObjectCommunicationServer() {
        return new NettyCommunnicationServer(Integer.parseInt(CommunicationConf.get("expose-port")));
    }

    private LoadBalance getLoadBalance() {
        return new RandomLoadBalance();
    }

    private LocationManager getLocationManager() {
        return ZookeeperLocationManager.getInstance();
    }
    private LocationObserver getLocationObserver(ConcurrentHashMap<String, List<String>> locationTable) {
        return new ZookeeperLocationObserver(locationTable);
    }
    @Override
    public String findDestination(String objName) {
        //find in the locationTable first
        List<String> locations=null;
        if((locations=locationTable.get(objName))==null){
            //find with location manager
            locations = locationManager.getLocationInfo(objName);
        };
        if(locations==null||locations.size()==0){
            throw new RemoteObjectNotFoundException("can not find object:"+objName);
        }
        String location=loadBalance.choose(locations);
        return location;
    }

    @Override
    public void receiveMessage(CommunicationMessage message) {

    }

    @Override
    public void sendMessage(CommunicationMessage message) {
        logger.info("message send by gateway"+":"+ FastJsonUtil.toJson(message));
        String location=findDestination(message.getFullToObjName());
        ObjectCommunicationClient client = getClient(location);
        try {
            client.sendMessage(message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

    }

    private  ObjectCommunicationClient getClient(String location) {
        ObjectCommunicationClient communicationClient = clients.get(location);
        if(communicationClient==null){
            String[] strs=location.split(":");
            communicationClient=new NettyCommunicationClient(strs[0],Integer.parseInt(strs[1]));
            communicationClient.startClient();
            clients.put(location,communicationClient);
        }
        return communicationClient;
    }

    @Override
    public void translateMessage() {

    }
}
