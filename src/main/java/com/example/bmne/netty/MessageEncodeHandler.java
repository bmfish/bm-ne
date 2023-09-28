package com.example.bmne.netty;

import com.example.bmne.config.MessageBean;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.CharsetUtil;

public class MessageEncodeHandler extends MessageToByteEncoder<MessageBean> {


    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, MessageBean messageBean, ByteBuf byteBuf) throws Exception {
        byteBuf.writeInt(messageBean.getLen());
        byteBuf.writeBytes(messageBean.getContent());
    }

}
