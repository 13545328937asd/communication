package com.wzx.messagebuilder.loadbalance;

import java.util.List;

public interface LoadBalance {
    public String choose(List<String> locations);
}
