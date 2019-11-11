package com.wzx.message;

import com.wzx.serialize.FastJsonUtil;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class MessageDisposeTask implements Runnable {
    Logger logger= LoggerFactory.getLogger(MessageDisposeTask.class);
    ChannelHandlerContext ctx;
    private CommunicationMessage message;

    public MessageDisposeTask(ChannelHandlerContext ctx, CommunicationMessage message) {
        this.ctx=ctx;
        this.message=message;
    }
    public MessageDisposeTask(CommunicationMessage message) {
        this.message=message;
    }
    @Override
    public void run() {
        MessageDisposeCenter messageDisposeCenter = SpringBeanAccessor.getBean(MessageDisposeCenter.class);
        try {
            messageDisposeCenter.messageDispose(message);
            message.getFutureAnswer().get(10, TimeUnit.SECONDS);
            logger.info(FastJsonUtil.toJson(message));
            ResponseMessage responseMessage=new ResponseMessage(message.getMessageId(),message.getFutureAnswer().get(10, TimeUnit.SECONDS));
            if(ctx!=null){
                ctx.writeAndFlush(responseMessage).sync();
            }
        } catch (Exception e) {
                if(ctx!=null){
                ctx.fireExceptionCaught(e);
            }
        }finally {
            if(ctx!=null){
                ctx.close();
            }
        }



    }
}
