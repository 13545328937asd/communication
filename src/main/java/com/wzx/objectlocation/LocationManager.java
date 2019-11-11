package com.wzx.objectlocation;

import java.util.List;

public interface LocationManager {
    public void publishLocationInfo(String name ,String ip ,String port);
    public List<String> getLocationInfo(String name);
    public void deleteLocationInfo(String name,String ip,String port);
}
