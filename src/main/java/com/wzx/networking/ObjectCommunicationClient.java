package com.wzx.networking;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public interface ObjectCommunicationClient {
    public void startClient();
    public void sendMessage(CommunicationMessage message) throws InterruptedException, ExecutionException, TimeoutException;
}
