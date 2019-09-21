package com.wzx.messagebuilder.networking;

import com.wzx.messagebuilder.exceptions.UnrecognizedResponseMessageException;
import com.wzx.messagebuilder.message.CommunicationMessage;
import com.wzx.messagebuilder.message.ResponseMessage;
import com.wzx.messagebuilder.serialize.FastJsonUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.ConcurrentHashMap;

@ChannelHandler.Sharable
public class ClientCommunicationHandler extends ChannelInboundHandlerAdapter {
    private ConcurrentHashMap<String, CommunicationMessage> messageMap;
    public ClientCommunicationHandler(ConcurrentHashMap<String, CommunicationMessage> messageMap){
        this.messageMap=messageMap;
    }
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(FastJsonUtil.toJson(msg));
        String messageId=((ResponseMessage)msg).getMessageId();
        CommunicationMessage message=messageMap.get(messageId);
        if(message==null){
            ctx.fireExceptionCaught(new UnrecognizedResponseMessageException(messageId));
        }else {
            message.getFutureAnswer().setResult(((ResponseMessage)msg).getResponse());
            //remove the message from the map
            messageMap.remove(messageId);
        }

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
