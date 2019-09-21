package com.wzx.messagebuilder.gateway;

import com.wzx.messagebuilder.message.CommunicationMessage;

public interface MessageGateWay {
    public String findDestination(String objName);
    public void receiveMessage(CommunicationMessage message);
    public void sendMessage(CommunicationMessage message);
    public void translateMessage();
}
