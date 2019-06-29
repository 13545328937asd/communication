package com.wzx.gateway;

import com.wzx.message.CommunicationMessage;

public interface MessageGateWay {
    public String findDestination(String objName);
    public void receiveMessage();
    public void sendMessage(CommunicationMessage message);
    public void translateMessage();
}