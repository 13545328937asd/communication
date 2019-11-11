package com.wzx.message;

import com.alibaba.fastjson.JSONObject;
import com.wzx.message.exceptions.CommunicationTimeOutException;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;




public class FutureAnswer  implements Future {
    public volatile Object answer;
    private volatile boolean isDone;
    private volatile boolean answered;//whether the message has been answered
    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }
    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        return isDone;
    }

    @Override
    public Object get() throws InterruptedException, ExecutionException {
        synchronized (this){
            while(!answered){
                wait();
            }
        }
        return answer;
    }

    public <T> T  get(Class<T> clazz) throws InterruptedException, ExecutionException {
        synchronized (this){
            while(!answered){
                wait();
            }
        }
        if(answer.getClass().isPrimitive()){
            return (T)answer;
        }
        if(answer instanceof JSONObject){
            T object = ((JSONObject) answer).toJavaObject(clazz);
            return object;
        }
        return (T)answer;
    }

    @Override
    public Object get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        long startTime=System.currentTimeMillis();
        long leftTime=0;
        long waitTotalTime=unit.toMillis(timeout);
        synchronized (this){
            leftTime=waitTotalTime-(System.currentTimeMillis()-startTime);
            while(!answered&&leftTime>0){
                wait(leftTime);
                leftTime=waitTotalTime-(System.currentTimeMillis()-startTime);
            }
            if(!answered){
                throw  new CommunicationTimeOutException("can not get the result in the given time");
            }
            return answer;
        }
    }
    public void setResult(Object answer){
        synchronized (this){
            this.answer=answer;
            answered=true;
            isDone=true;
            notifyAll();
        }
    }
}
