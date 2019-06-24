package com.wzx.message;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureAnswer  implements Future {
    private Object answer;
    private  boolean isDone;
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
                return answer;
            }
            return answer;
        }
    }

    @Override
    public Object get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        synchronized (this){
            while(!answered){
                wait(unit.toMillis(timeout));
                return answer;
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
