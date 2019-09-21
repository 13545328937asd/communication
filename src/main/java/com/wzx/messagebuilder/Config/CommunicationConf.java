package com.wzx.messagebuilder.Config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CommunicationConf {
    static  Properties  communication;
    public static String  get(String key){
        return communication.getProperty(key);
    }
    static {
        communication=new Properties();
        InputStream inputStream = CommunicationConf.class.getClassLoader().getResourceAsStream("Communication.properties");
        try {
            communication.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
