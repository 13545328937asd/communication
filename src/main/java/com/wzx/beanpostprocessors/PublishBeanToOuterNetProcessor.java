package com.wzx.beanpostprocessors;

import com.wzx.Config.CommunicationConf;
import com.wzx.Voluble;
import com.wzx.annotations.ExposeToOuterNet;
import com.wzx.controller.TestCommunicationController;
import com.wzx.objectlocation.LocationManager;
import com.wzx.objectlocation.ZookeeperLocationManager;
import org.I0Itec.zkclient.ZkClient;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

@Component
public class PublishBeanToOuterNetProcessor  implements BeanFactoryPostProcessor {
    private LocationManager locationManager;
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        if(locationManager==null){
            locationManager=ZookeeperLocationManager.getInstance();
        }
        String ip;
        try {
            ip= InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            throw new RuntimeException("can not get local host");
        }
        String[] volubleNames=beanFactory.getBeanNamesForType(Voluble.class);
        //String[] names=beanFactory.getBeanNamesForAnnotation(ExposeToOuterNet.class);
        for(String name:volubleNames){
            BeanDefinition beanDefinition=beanFactory.getBeanDefinition(name);
            String beanClassName=beanDefinition.getBeanClassName();
            try {
                if(Class.forName(beanClassName).isAnnotationPresent(ExposeToOuterNet.class)){
                    locationManager.publishLocationInfo(beanClassName,ip, CommunicationConf.get("expose-port"));
                };
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

}
