package com.wzx.messagebuilder.networking;

import com.wzx.messagebuilder.serialize.FastJsonUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.nio.charset.Charset;

public class CommunicationMessageEncoderHandler  extends MessageToByteEncoder {
    private final String delimiter;
    public CommunicationMessageEncoderHandler(String delimiter) {
        this.delimiter = delimiter;
    }
    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
        byte[] bytes= FastJsonUtil.toJson(msg).getBytes(Charset.forName("utf-8"));
        out.writeBytes(bytes);
        out.writeBytes(delimiter.getBytes(Charset.forName("utf-8")));
    }
}
