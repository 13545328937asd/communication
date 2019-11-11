package com.wzx.networking;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.pool.ChannelPoolHandler;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;

import java.util.concurrent.ConcurrentHashMap;

public class DefaultChanelPoolHandler  implements ChannelPoolHandler {
    private ConcurrentHashMap<String, CommunicationMessage> messageMap;
    private final String delimiter;
    public DefaultChanelPoolHandler(ConcurrentHashMap<String, CommunicationMessage> messageMap, String delimiter) {
        this.messageMap=messageMap;
        this.delimiter=delimiter;
    }


    @Override
    public void channelReleased(Channel ch) throws Exception {
        System.out.println("连接释放");
    }

    @Override
    public void channelAcquired(Channel ch) throws Exception {
        System.out.println("连接获取");
    }

    @Override
    public void channelCreated(Channel ch) throws Exception {
        System.out.println("连接创建");
        ByteBuf byteBuf = Unpooled.copiedBuffer(delimiter.getBytes());
        ch.pipeline().addLast(new CommunicationMessageEncoderHandler(delimiter));
        ch.pipeline().addLast(new DelimiterBasedFrameDecoder(1024,byteBuf));
        ch.pipeline().addLast(new ClientCommMessageDecoderHandler());
        ch.pipeline().addLast(new ClientCommunicationHandler(messageMap));
    }
}
