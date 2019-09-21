package com.wzx.messagebuilder.message;

public class MessageDetail {
    private String words;//提示，通常是方法名。告訴别人做什么事情，调用某一个方法。
    private Object[] extraInfo;//额外参数，通常指方法参数或返回参数。

    public MessageDetail(String words, Object[] extraInfo) {
        this.words = words;
        this.extraInfo = extraInfo;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    public Object[] getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(Object[] extraInfo) {
        this.extraInfo = extraInfo;
    }
}
