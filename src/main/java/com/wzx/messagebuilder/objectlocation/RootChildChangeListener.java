package com.wzx.messagebuilder.objectlocation;

import org.I0Itec.zkclient.IZkChildListener;

import java.net.InetSocketAddress;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class RootChildChangeListener implements IZkChildListener {
    private ConcurrentHashMap<String, InetSocketAddress> locationInfo;
    public RootChildChangeListener(ConcurrentHashMap<String, InetSocketAddress> locationInfo){
        this.locationInfo=locationInfo;
    }
    @Override
    public void handleChildChange(String parentPath, List<String> currentChilds) throws Exception {

    }
}
