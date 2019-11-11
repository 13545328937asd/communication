package com.wzx.loadbalance;

import java.util.List;

public interface LoadBalance {
    public String choose(List<String> locations);
}
