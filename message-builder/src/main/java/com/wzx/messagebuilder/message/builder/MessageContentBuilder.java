package com.wzx.messagebuilder.message.builder;

import com.wzx.messagebuilder.message.MessageContent;
import com.wzx.messagebuilder.tools.FastJsonUtil;
import com.wzx.messagebuilder.tools.StringTools;

import java.util.HashMap;
import java.util.Map;

public  class MessageContentBuilder {
    private String words;
    private String wordsDesc;
    private Map<String,Object> paramValueMap=new HashMap<>();
    //divide paramInfo into two map(one for key:value,another for key:desc).because
    // at present we only care about the key:value
    private Map<String,String> paramDescMap=new HashMap<>();
    public MessageContentBuilder words(String words){
        this.words=words;
        return this;
    }
    public MessageContentBuilder wordsDesc(String wordsDesc){
        this.wordsDesc=wordsDesc;
        return this;
    }
    public MessageContentBuilder buildParam(String key,Object value,String desc){
        paramValueMap.put(key,value);
        if(StringTools.isNotEmpty(desc)){
            paramDescMap.put(key,desc);
        }
        return this;
    }
    public MessageContentBuilder buildParam(Map<String,Object> paramValueMap){
        if(paramValueMap!=null){
            paramValueMap.putAll(paramValueMap);
        }
        return this;
    }
    public MessageContentBuilder buildParam(Map<String,Object> paramValueMap,Map<String,String> paramDescMap){
        if(paramValueMap!=null){
            this.paramValueMap.putAll(paramValueMap);
        }
        if(paramDescMap!=null){
            this.paramDescMap.putAll(paramDescMap);
        }
        return this;
    }
    public MessageContent build(){
        String paramValueJson = FastJsonUtil.toJson(paramValueMap);
        String paramDescJson=FastJsonUtil.toJson(paramDescMap);
        return new MessageContent(words,wordsDesc,null,paramValueJson,paramDescJson);
    }
}
