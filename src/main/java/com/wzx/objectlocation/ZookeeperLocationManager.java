package com.wzx.objectlocation;

import com.wzx.Config.CommunicationConf;
import org.I0Itec.zkclient.ZkClient;

import java.util.ArrayList;
import java.util.List;

public class ZookeeperLocationManager implements LocationManager {
    public static ZookeeperLocationManager locationManager=new ZookeeperLocationManager();
    private ZkClient zkClient;
    public static final String prefix="/communication";
    private ZookeeperLocationManager(){
        this.zkClient=new ZkClient(CommunicationConf.get("zookeeper"));
        init();
    }
    public void init(){
        if(!zkClient.exists(prefix)){
            zkClient.createPersistent(prefix);
        }
    }
    @Override
    public void publishLocationInfo(String name, String ip, String port) {
       String location= genarateLocation(ip,port);
       String providerPath=getProviderPath(name);
       if(!checkNodeExist(providerPath)){
           zkClient.createPersistent(prefix+"/"+name+"/providers",true);
       }
       String locationPath=providerPath+"/"+location;
       if(!checkNodeExist(locationPath)){
           zkClient.createEphemeral(locationPath);
       }
    }

    private String  genarateLocation(String ip, String port) {
        return ip+":"+port;
    }

    @Override
    public List<String> getLocationInfo(String name) {
        String providerPath=getProviderPath(name);
        if(!checkNodeExist(providerPath)){
            return new ArrayList<String>();
        }
        return zkClient.getChildren(providerPath);
    }
    public boolean checkNodeExist(String name){
        boolean exists=false;
        if(zkClient.exists(name)){
            exists=true;
        }
        return exists;
    };
    @Override
    public void deleteLocationInfo(String name, String ip, String port) {
        String locationPath=getLocationPath(name,ip,port);
        if(checkNodeExist(locationPath)){
           zkClient.delete(locationPath);
        };
    }
    public String getLocationPath(String name,String ip,String port){
        return getProviderPath(name)+genarateLocation(ip,port);
    }
    public String getProviderPath(String name){
        return prefix+"/"+name+"/providers";
    }
    public static ZookeeperLocationManager getInstance(){
        return locationManager;
    }
}
