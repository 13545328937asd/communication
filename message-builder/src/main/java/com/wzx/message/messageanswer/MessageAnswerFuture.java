package com.wzx.message.messageanswer;


import com.wzx.message.MessageContent;
import com.wzx.message.exceptions.AnswerTimeOutException;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MessageAnswerFuture implements Answer, Future<MessageContent> {
    private static final int waiting=0;
    private static final int complete=1;
    private volatile int state=waiting;
    private MessageContent answerContent;
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        return state==complete;
    }

    @Override
    public MessageContent get() throws InterruptedException, ExecutionException {
        synchronized (this){
            while(!isDone()){
                wait();
            }
        }
        return answerContent;
    }

    @Override
    public MessageContent get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        long startTime=System.currentTimeMillis();
        long leftTime=0;
        long waitTotalTime=unit.toMillis(timeout);
        synchronized (this){
            leftTime=waitTotalTime-(System.currentTimeMillis()-startTime);
            while(!isDone()&&leftTime>0){
                wait(leftTime);
                leftTime=waitTotalTime-(System.currentTimeMillis()-startTime);
            }
            if(!isDone()){
                throw  new AnswerTimeOutException("can not get the result in the given time");
            }
            return answerContent;
        }
    }
    public void set(MessageContent messageAnswer){
        synchronized (this){
            state=complete;
            this.answerContent=messageAnswer;
            notifyAll();
        }

    }

    @Override
    public Object getAnswer() {
        return null;
    }
}
