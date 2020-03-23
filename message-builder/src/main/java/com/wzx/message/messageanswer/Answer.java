package com.wzx.message.messageanswer;

public interface Answer<T> {
    public <T> T getAnswer();

    /**
     * the requesr object will get a message  as a response
     */
    public void ansnerWithMessage();
    /**
     * the request object will get a Object as a response
     */
    public void answerImmediately();
}
