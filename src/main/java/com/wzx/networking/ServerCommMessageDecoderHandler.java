package com.wzx.networking;

import com.wzx.message.CommunicationMessage;
import com.wzx.serialize.FastJsonUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.nio.charset.Charset;
import java.util.List;

public class ServerCommMessageDecoderHandler extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        int readableBytes=byteBuf.readableBytes();
        System.out.println(readableBytes);
        String messeageString=byteBuf.toString(Charset.forName("utf-8"));
        System.out.println(messeageString);
        CommunicationMessage message = FastJsonUtil.toObject(messeageString, CommunicationMessage.class);
        list.add(message);
        byteBuf.skipBytes(readableBytes);
        byteBuf.writeBytes()

    }
}
