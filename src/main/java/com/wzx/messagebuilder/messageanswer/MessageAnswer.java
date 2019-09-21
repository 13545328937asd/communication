package com.wzx.messagebuilder.messageanswer;

public  class MessageAnswer implements Answer{
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
}
