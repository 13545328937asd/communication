package com.wzx.objectlocation;

import org.I0Itec.zkclient.IZkChildListener;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ProviderChangeListener implements IZkChildListener {
    private ConcurrentHashMap<String,List<String>>  locationInfo;
    public ProviderChangeListener(ConcurrentHashMap<String, List<String>> locationInfo){
        this.locationInfo=locationInfo;
    }
    @Override
    public void handleChildChange(String parentPath, List<String> currentChilds) throws Exception {
       System.out.println(parentPath);
        String[] pathArr=parentPath.split("/");
        String name =pathArr[pathArr.length-2];
        List<String> addresses=new ArrayList<>();
        if(currentChilds==null||currentChilds.size()==0){
            locationInfo.put(name,addresses);
            return;
        }
        for(String child:currentChilds){
            addresses.add(child);
        }
        locationInfo.put(name,addresses);
    }
}
