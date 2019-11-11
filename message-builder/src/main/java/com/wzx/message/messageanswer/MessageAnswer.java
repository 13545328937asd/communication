package com.wzx.message.messageanswer;


import com.wzx.message.MessageContent;

public  class MessageAnswer implements Answer<MessageContent> {
    private MessageContent messageContent;
    private String answerWords;
    public Object answerContent;

    public MessageAnswer(String answerWords, Object answerContent) {
        this.answerWords = answerWords;
        this.answerContent = answerContent;
    }

    public String getAnswerWords() {
        return answerWords;
    }

    public Object getAnswerContent() {
        return answerContent;
    }

    @Override
    public MessageContent getAnswer() {
        return null;
    }
}
