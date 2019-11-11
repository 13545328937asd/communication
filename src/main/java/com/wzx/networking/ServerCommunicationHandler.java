package com.wzx.networking;

import com.wzx.message.MessageDisposeThreadPool;
import com.wzx.message.SpringBeanAccessor;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ServerCommunicationHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        CommunicationMessage communicationMessage= (CommunicationMessage) msg;
        System.out.println(communicationMessage.getToObjName());
        MessageDisposeThreadPool threadPool = SpringBeanAccessor.getBean(MessageDisposeThreadPool.class);
        threadPool.asynDisposeMessage(ctx,communicationMessage);//asyn ack
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        /*ctx.writeAndFlush(Unpooled.EMPTY_BUFFER)*//*flush掉所有的数据*//*
                .addListener(ChannelFutureListener.CLOSE);*//*当flush完成后，关闭连接*/
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx,cause);
        ctx.close();
    }
}
