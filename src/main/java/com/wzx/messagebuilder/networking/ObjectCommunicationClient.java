package com.wzx.messagebuilder.networking;

import com.wzx.messagebuilder.message.CommunicationMessage;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public interface ObjectCommunicationClient {
    public void startClient();
    public void sendMessage(CommunicationMessage message) throws InterruptedException, ExecutionException, TimeoutException;
}
