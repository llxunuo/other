package com;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;

public class NettyServer {
    public static void main(String[] args) {
        ServerBootstrap serverBootstrap = new ServerBootstrap();    //引导我们进行服务端的启动工作

        //1.boos对应，IOServer.java中的接受新连接线程，主要负责创建新连接
        //2.worker对应 IOClient.java中的负责读取数据的线程，主要用于读取数据以及业务逻辑处理
        NioEventLoopGroup boos = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();
        //指定线程模型，IO模型，连接读写处理逻辑,绑定接口
        serverBootstrap
                .group(boos, worker)                    //给引导类配置两大线程，这个引导类的线程模型也就定型了。
                .channel(NioServerSocketChannel.class)      //指定我们服务端的IO模型为NIO
                .childHandler(new ChannelInitializer<NioSocketChannel>() {      //定义后续每条连接的数据读写，业务处理逻辑
                    protected void initChannel(NioSocketChannel ch) {
                        ch.pipeline().addLast(new StringDecoder());
                        ch.pipeline().addLast(new SimpleChannelInboundHandler<String>() {
                            @Override
                            protected void channelRead0(ChannelHandlerContext ctx, String msg) {
                                System.out.println(msg);
                            }
                        });
                    }
                })
                .bind(8000); //绑定接口
    }
}