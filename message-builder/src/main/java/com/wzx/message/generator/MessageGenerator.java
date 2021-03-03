package com.wzx.message.generator;


import com.wzx.message.MessageContent;

public interface MessageGenerator {
    /**
     * when the client prepared a specific DTO for api calling,the method will be useful
     * @param object
     * @return
     */
    MessageContent generateWithSpecificDto(Object object);
}
