package com.wzx.loadbalance;

import java.util.List;

public class RandomLoadBalance implements LoadBalance{
    @Override
    public String choose(List<String> locations) {
        int length=locations.size();
        int position= (int) (Math.random()*length);
        return locations.get(position);
    }
}
