package com.wzx.gateway;

public interface MessageGateWay {
    public String findDestination(String objName);
    public void receiveMessage(CommunicationMessage message);
    public void sendMessage(CommunicationMessage message);
    public void translateMessage();
}
