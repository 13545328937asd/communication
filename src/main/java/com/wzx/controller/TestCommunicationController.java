package com.wzx.controller;

import com.wzx.gateway.MessageGateWay;
import com.wzx.message.CommunicationMessage;
import com.wzx.message.CommunicationMessageBuilder;
import com.wzx.message.MessageType;
import com.wzx.Voluble;
import com.wzx.service.impl.TestCommunicationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/communication")
public class TestCommunicationController implements Voluble {
    @Resource
    MessageGateWay messageGateWay;
    @Autowired
    private TestCommunicationServiceImpl service;
    @RequestMapping("/test")
    public String test(String name) throws Exception {
        System.out.println("controller----"+name);
        CommunicationMessage message= CommunicationMessageBuilder.getInstance().buildObjInfo(this, TestCommunicationServiceImpl.class)
                .buildMessageType(MessageType.REQUEST).buildToAppName("order")
                .buildMessageDetail("test",new Object[]{name}).getCm();
        String result=speak(message).get(String.class);
        CommunicationMessage message1=CommunicationMessageBuilder.getInstance().buildObjInfo(this, TestCommunicationServiceImpl.class)
                .buildMessageType(MessageType.REQUEST).buildToAppName("order")
                .buildMessageDetail("test",new Object[]{name}).getCm();
        messageGateWay.sendMessage(message1);
        message1.getFutureAnswer().get(String.class);
        return result;
    }
    @RequestMapping("/queryInfos")
    public Map<String,String> queryInfos(String id) throws ExecutionException, InterruptedException {
        /*CommunicationMessage message=CommunicationMessageBuilder.getInstance().buildObjInfo(this, TestCommunicationServiceImpl.class)
                .buildMessageDetail("queryInfos",new Object[]{id}).getCm();
        Object obj=speak(message).get();
        return (Map<String, String>) obj;*/
        CommunicationMessage message=CommunicationMessageBuilder.getInstance().buildObjInfo(this, TestCommunicationServiceImpl.class)
                .buildMessageDetail("dadoudou",new Object[]{}).getCm();
        String str= (String) speak(message).get();
        System.out.println(str);
        return new HashMap<>();
    }


}
