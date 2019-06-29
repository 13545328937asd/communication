package com.wzx.gateway;

import com.wzx.Voluble;
import com.wzx.exceptions.RemoteObjectNotFoundException;
import com.wzx.loadbalance.LoadBalance;
import com.wzx.loadbalance.RandomLoadBalance;
import com.wzx.message.CommunicationMessage;
import com.wzx.objectlocation.LocationManager;
import com.wzx.objectlocation.LocationObserver;
import com.wzx.objectlocation.ZookeeperLocationManager;
import com.wzx.objectlocation.ZookeeperLocationObserver;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Component("messageGateWay")
public class DefaultMessageGateWay implements  MessageGateWay, Voluble {
    private LocationManager locationManager;
    private LocationObserver locationObserver;
    private LoadBalance loadBalance;
    ConcurrentHashMap<String, List<String>> locationTable=new ConcurrentHashMap<>();
    @PostConstruct
    public void init(){
        locationObserver=getLocationObserver(locationTable);
        locationManager=getLocationManager();
        loadBalance=getLoadBalance();
        locationObserver.startObserve();
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
    ;
    @Override
    public String findDestination(String objName) {
        //find in the locationTable first
        List<String> locations=null;
        if(locationTable.get(objName)==null){
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
    public void receiveMessage() {

    }

    @Override
    public void sendMessage(CommunicationMessage message) {
        String location=findDestination(message.getToObjName());

    }

    @Override
    public void translateMessage() {

    }
}
