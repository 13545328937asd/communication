package com.wzx.message.storage;

import com.wzx.message.CommunicationMessage;

import java.util.concurrent.ConcurrentHashMap;

public class LocalMessageStore implements MessageStore {
    private final ConcurrentHashMap<String,CommunicationMessage> messageConcurrentHashMap=new ConcurrentHashMap<>();
    @Override
    public void storeMessage(CommunicationMessage message) {
        messageConcurrentHashMap.put(message.getMessageId(),message);
    }

    @Override
    public void removeMessage(CommunicationMessage message) {
        messageConcurrentHashMap.remove(message.getMessageId());
    }

    @Override
    public CommunicationMessage getMessage(String messageId) {
        return messageConcurrentHashMap.get(messageId);
    }
}
