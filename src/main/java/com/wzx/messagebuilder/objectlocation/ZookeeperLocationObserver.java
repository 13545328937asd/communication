package com.wzx.messagebuilder.objectlocation;

import com.wzx.messagebuilder.Config.CommunicationConf;
import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.ZkClient;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ZookeeperLocationObserver  implements LocationObserver{
    private ZookeeperLocationManager locationManager;
    private IZkChildListener providerListener;
    private List<String>  newAddedName=new ArrayList<>();
    private ZkClient zkClient;
    private ConcurrentHashMap<String, List<String>> locationTable;
    public static final String ROOT="/communication";
    public ZookeeperLocationObserver(ConcurrentHashMap<String, List<String>> locationTable){
        this.locationTable=locationTable;
        this.providerListener=new ProviderChangeListener(locationTable);
        if(zkClient==null){
            zkClient=new ZkClient(CommunicationConf.get("zookeeper"));
            locationManager=ZookeeperLocationManager.getInstance();
        }
    }
    @Override
    public void startObserve() {
        List<String> names=zkClient.getChildren(ROOT);
        if(names==null|| names.size()==0){
            return;
        }
        for(String name:names){
            addToObserver(name);
        }
    }
    public void addToObserver(String name){
        String providerPath=locationManager.getProviderPath(name);
        if(locationManager.checkNodeExist(providerPath)){
            zkClient.subscribeChildChanges(providerPath,providerListener);
            List<String> locationInfo = locationManager.getLocationInfo(name);
            if(locationInfo==null){
                locationInfo=new ArrayList<>();
            }
            locationTable.put(name,locationInfo);
        }
    }

}
