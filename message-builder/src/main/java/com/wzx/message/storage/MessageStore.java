package com.wzx.message.storage;

import com.wzx.message.CommunicationMessage;

public interface MessageStore {
    public void storeMessage(CommunicationMessage message);
    void removeMessage(CommunicationMessage message);
    CommunicationMessage getMessage(String messageId);
}
