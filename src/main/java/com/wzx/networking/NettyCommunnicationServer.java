package com.wzx.networking;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;


import java.net.InetSocketAddress;
public class NettyCommunnicationServer  implements  ObjectCommunicationServer{
    private int port;
    private static final String delimiter=";;";
    public NettyCommunnicationServer(int port){
        this.port=port;
    }
    @Override
    public void startServer() throws InterruptedException {
        System.out.println("SERVER 启动");
        EventLoopGroup group = new NioEventLoopGroup();
        EventLoopGroup work = new NioEventLoopGroup();

        ServerBootstrap b = new ServerBootstrap();/*服务端启动必备*/
        try {
            b.group(group,work)
                    /*指明使用NIO进行网络通讯*/
                    .channel(NioServerSocketChannel.class)
                    //.channel(EpollServerSocketChannel.class)
                    /*指明服务器监听端口*/
                    .localAddress(new InetSocketAddress(port))
                    /*接收到连接请求，新启一个socket通信，也就是channel，每个channel
                     * 有自己的事件的handler*/
                    .childOption(ChannelOption.TCP_NODELAY,true)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
    //                            ch.pipeline().addLast(new EchoServerHandler());
                            ByteBuf byteBuf = Unpooled.copiedBuffer(delimiter.getBytes());
                            ch.pipeline().addLast(new CommunicationMessageEncoderHandler(delimiter));
                            ch.pipeline().addLast(new DelimiterBasedFrameDecoder(1024,byteBuf));
                            ch.pipeline().addLast(new ServerCommMessageDecoderHandler());
                            ch.pipeline().addLast(new ServerCommunicationHandler());
                        }
                    });
            ChannelFuture f = b.bind().sync();/*绑定到端口，阻塞等待直到连接完成*/
            f.channel().closeFuture().sync();
        } finally {
            System.out.println("SERVER 关闭");
            group.shutdownGracefully().sync();
            work.shutdownGracefully().sync();
        }
    }
}
