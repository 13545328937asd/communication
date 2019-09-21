package com.wzx.messagebuilder.message;

public class MessageContent {
    /**
     * words help the toObj understand what should do,usually a method name
     */
    private String words;
    /**
     * help the developer(person) to understand the words
     */
    private String wordsDesc;
    private Object[] extraInfo;//额外参数，通常指方法参数或返回参数。
    /**
     * params in json format,
     */
    private String paramValueJson;
    private String paramDescJson;
    public MessageContent(String words, String wordsDesc,Object[] extraInfo,String paramJson,String paramDescJson) {
        this.words = words;
        this.wordsDesc=wordsDesc;
        this.extraInfo = extraInfo;
        this.paramValueJson=paramJson;
        this.paramDescJson=paramDescJson;
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

    public String getWordsDesc() {
        return wordsDesc;
    }

    public void setWordsDesc(String wordsDesc) {
        this.wordsDesc = wordsDesc;
    }

    public String getParamValueJson() {
        return paramValueJson;
    }

    public void setParamValueJson(String paramValueJson) {
        this.paramValueJson = paramValueJson;
    }

    public String getParamDescJson() {
        return paramDescJson;
    }

    public void setParamDescJson(String paramDescJson) {
        this.paramDescJson = paramDescJson;
    }
}
