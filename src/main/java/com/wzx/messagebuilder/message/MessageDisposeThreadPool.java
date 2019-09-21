package com.wzx.messagebuilder.message;

import io.netty.channel.ChannelHandlerContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@Component
public class MessageDisposeThreadPool {
    private ThreadPoolExecutor executor;
    @PostConstruct
    public void init(){
        executor= (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
    }
    public void asynDisposeMessage(ChannelHandlerContext ctx, CommunicationMessage message){
        MessageDisposeTask messageDisposeTask = new MessageDisposeTask(ctx,message);
        executor.execute(messageDisposeTask);
    }
    public void asynDisposeMessage(CommunicationMessage message){
        MessageDisposeTask messageDisposeTask = new MessageDisposeTask(message);
        executor.execute(messageDisposeTask);
    }
}
