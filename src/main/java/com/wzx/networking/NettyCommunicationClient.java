package com.wzx.networking;

import com.wzx.Config.CommunicationConf;
import com.wzx.message.CommunicationMessage;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.pool.FixedChannelPool;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.util.concurrent.Future;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
public class NettyCommunicationClient  implements ObjectCommunicationClient{
    private FixedChannelPool channelPool;
    private Bootstrap b;
    private final String ip;
    private final int port;
    private ConcurrentHashMap<String, CommunicationMessage> messageMap=new ConcurrentHashMap<>();
    private static final String delimiter=";;";
    public NettyCommunicationClient(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }
    @Override
    public void startClient() {
        EventLoopGroup group = new NioEventLoopGroup();/*线程组*/
        b = new Bootstrap();/*客户端启动必备*/
        b.group(group)
                .channel(NioSocketChannel.class)/*指明使用NIO进行网络通讯*/
                .remoteAddress(new InetSocketAddress(ip,port));/*配置远程服务器的地址*/
                /*.handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ByteBuf byteBuf = Unpooled.copiedBuffer(delimiter.getBytes());
                        ch.pipeline().addLast(new CommunicationMessageEncoderHandler(delimiter));
                        ch.pipeline().addLast(new DelimiterBasedFrameDecoder(1024,byteBuf));
                        ch.pipeline().addLast(new CommunicationMessageDecoderHandler());
                        ch.pipeline().addLast(new ClientCommunicationHandler(messageMap));
                    }
                }*/
        channelPool=new FixedChannelPool(b,new DefaultChanelPoolHandler(messageMap,delimiter),3);
    }

    @Override
    public void sendMessage(CommunicationMessage message) throws InterruptedException, ExecutionException, TimeoutException {
        Channel channel=null;
        try {
            messageMap.put(message.getMessageId(),message);
            channel= getChannel(Long.parseLong(CommunicationConf.get("client-channel-acquire-timeout")), TimeUnit.SECONDS);
            channel.pipeline().writeAndFlush(message).sync();
        }finally {
            if(channel!=null){
                channelPool.release(channel);
            }
        }
    }
    public Channel getChannel(long time, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        Future<Channel> channelFuture = channelPool.acquire();
        Channel channel = channelFuture.get(time, unit);
        return  channel;
    }
}
