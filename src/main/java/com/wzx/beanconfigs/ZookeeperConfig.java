package com.wzx.beanconfigs;

import org.I0Itec.zkclient.ZkClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZookeeperConfig {
    @Bean
    public ZkClient zkClient(){
        ZkClient zkClient=new ZkClient("127.0.0.1:2181");
        return zkClient;
    }

}
