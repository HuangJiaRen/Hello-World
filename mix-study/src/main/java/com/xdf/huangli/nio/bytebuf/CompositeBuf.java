package com.xdf.huangli.nio.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

import java.util.Arrays;


/**
 * @author huangli
 * @version 1.0
 * @description TODO
 * @date 2019-10-12 10:50
 */
public class CompositeBuf {
   /* public static void main(String[] args) {
      *//*  CompositeByteBuf messageBuf = Unpooled.compositeBuffer();
        ByteBuf headerBuf = Unpooled.copiedBuffer("head", CharsetUtil.UTF_8);
        ByteBuf bodyBuf = Unpooled.copiedBuffer("body", CharsetUtil.UTF_8);
        messageBuf.addComponents(headerBuf, bodyBuf);
        System.out.println("Remove Head Before-----------");
        printCompositeBuffer(messageBuf);
//        for (ByteBuf buf : messageBuf) {
//            System.out.println(buf.toString(CharsetUtil.UTF_8));
//        }

        messageBuf.removeComponent(0);
        System.out.println("Remove Head After-----------");
        printCompositeBuffer(messageBuf);
//        for (ByteBuf buf: messageBuf){
//            System.out.println(buf.toString(CharsetUtil.UTF_8));
//        }*//*
    }

    private static void printCompositeBuffer(CompositeByteBuf compBuf) {
        int length = compBuf.readableBytes();
        byte[] array = new byte[length];
        compBuf.getBytes(compBuf.readerIndex(), array);
        System.out.println(Arrays.toString(array));
        System.out.println(length);
    }*/

    public static void main(String args[]) {
        ByteBuf directBuf = Unpooled.directBuffer(100);
        directBuf.writeBytes("direct buffer".getBytes());
        System.out.println(directBuf.getByte(10));
    }
}
