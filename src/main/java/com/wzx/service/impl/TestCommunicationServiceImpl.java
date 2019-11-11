package com.wzx.service.impl;

import com.wzx.Voluble;
import com.wzx.annotations.ExposeToOuterNet;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@ExposeToOuterNet
@Service
public class TestCommunicationServiceImpl implements Voluble {
    public String test(String name){
        System.out.println("service----"+name);
        return "service";
    }
    public Map<String,String> queryInfos(String id){
        Map<String,String> map=new HashMap<>();
        map.put("name","wzx");
        map.put("age","23");
        return map;
    }
    public String dadoudou(){
        return "dadoudou";
    }

    /*@Override
    public void listen(CommunicationMessage message) {
        MessageDetail detail=message.getMessageDetail();
        String hint=detail.getHint();
        Object[] args=detail.getExtraInfo();
        if("test".equals(hint)&&args.length==1){
            String str=test((String) args[0]);
            CommunicationMessage response= CommunicationMessageBuilder.getInstance().buildObjInfo(this, message.getFromObj().getClass())
                    .buildMessageType(MessageType.RESPONSE)
                    .buildMessageDetail("test",new Object[]{str}).getCm();
            speak(response);
        }
    }*/
}
