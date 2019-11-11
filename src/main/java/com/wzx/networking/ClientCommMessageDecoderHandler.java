package com.wzx.networking;

import com.wzx.message.ResponseMessage;
import com.wzx.serialize.FastJsonUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.nio.charset.Charset;
import java.util.List;

public class ClientCommMessageDecoderHandler extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        int readableBytes=byteBuf.readableBytes();
        String messeageString=byteBuf.toString(Charset.forName("utf-8"));
        ResponseMessage message = FastJsonUtil.toObject(messeageString, ResponseMessage.class);
        list.add(message);
        byteBuf.skipBytes(readableBytes);
    }
}
