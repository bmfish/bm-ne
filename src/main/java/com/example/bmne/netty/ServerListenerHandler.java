package com.example.bmne.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerListenerHandler extends SimpleChannelInboundHandler<Message> {
    private static final Logger log = LoggerFactory.getLogger(ServerListenerHandler.class);
 
    /**
     * 设备接入连接时处理
     *
     * @param ctx
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) {
        log.info("有新的连接：[{}]", ctx.channel().id().asLongText());
    }
 
    /**
     * 数据处理
     *
     * @param ctx
     * @param msg
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message msg) {
        // 获取消息实例中的消息体
        String content = msg.getContent();
        // 对不同消息类型进行处理
        MessageEnum type = MessageEnum.getStructureEnum(msg);
        switch (type) {
            case CONNECT:
                // TODO 心跳消息处理
            case STATE:
                // TODO 设备状态
            default:
                System.out.println(type.content + "消息内容" + content);
        }
    }
 
    /**
     * 设备下线处理
     *
     * @param ctx
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) {
        log.info("设备下线了:{}", ctx.channel().id().asLongText());
    }
 
    /**
     * 设备连接异常处理
     *
     * @param ctx
     * @param cause
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // 打印异常
        log.info("异常：{}", cause.getMessage());
        // 关闭连接
        ctx.close();
    }
}