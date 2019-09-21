package com.wzx.messagebuilder.messageanswer;

import com.wzx.messagebuilder.exceptions.CommunicationTimeOutException;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MessageAnswerFuture implements Answer, Future<MessageAnswer> {
    private static final int waiting=0;
    private static final int complete=1;
    private volatile int state=waiting;
    private MessageAnswer messageAnswer;
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
    public MessageAnswer get() throws InterruptedException, ExecutionException {
        synchronized (this){
            while(!isDone()){
                wait();
            }
        }
        return messageAnswer;
    }

    @Override
    public MessageAnswer get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
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
                throw  new CommunicationTimeOutException("can not get the result in the given time");
            }
            return messageAnswer;
        }
    }
    public void set(MessageAnswer messageAnswer){
        synchronized (this){
            state=complete;
            this.messageAnswer=messageAnswer;
            notifyAll();
        }

    }
}
