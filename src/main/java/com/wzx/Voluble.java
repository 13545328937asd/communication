package com.wzx;

import com.wzx.message.CommunicationMessage;
import com.wzx.message.FutureAnswer;
import com.wzx.message.MessageDisposeCenter;
import com.wzx.message.SpringBeanAccessor;
import com.wzx.words.DefaultWordsParser;
import com.wzx.words.WordsParser;
import org.springframework.util.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

public interface Voluble {
    public static final Map<Object, BlockingQueue<CommunicationMessage>> messages=new HashMap();

    default FutureAnswer speak(CommunicationMessage message){
        Object toObj=message.getToObj();
        if(toObj!=null){
            ((Voluble)toObj).listen(message);
        }else{
            sendMessageToDisposeCenter(message);
        }
        return message.getFutureAnswer();
    };
    default void sendMessageToDisposeCenter(CommunicationMessage message) {
        MessageDisposeCenter disposeCenter= SpringBeanAccessor.getBean(MessageDisposeCenter.class);
        disposeCenter.messageDispose(message);
    }
    default WordsParser getWordsParser(){
        return new DefaultWordsParser();
    };
    default void listen(CommunicationMessage message)  {
        WordsParser wordsParse = getWordsParser();
        Object returnObj=wordsParse.parseWords(this,message.getMessageDetail());
        message.getFutureAnswer().setResult(returnObj);
    };
}

