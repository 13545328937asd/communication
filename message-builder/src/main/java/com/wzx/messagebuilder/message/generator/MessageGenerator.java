package com.wzx.messagebuilder.message.generator;


import com.wzx.messagebuilder.message.MessageContent;

public interface MessageGenerator {
    /**
     * when the client prepared a specific DTO for api calling,the method will be useful
     * @param object
     * @return
     */
    MessageContent generateWithSpecificDto(Object object);
}
