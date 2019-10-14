package com.xdf.huangli.nio.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

import java.util.Arrays;

/**
 * @author huangli
 * @version 1.0
 * @description TODO
 * @date 2019-10-12 10:30
 */
public class ByteBufDemo {
    public static void main(String[] args) {
        //一.堆缓冲区
        /*ByteBuf heapBuf = Unpooled.copiedBuffer("heap space", CharsetUtil.UTF_8);

        if(heapBuf.hasArray()){//检查 ByteBuf 是否有一个支撑数组.当 hasArray()方法返回 false 时，
            // 尝试访问支撑数组将触发一个 UnsupportedOperationException。这个模式类似于 JDK 的 ByteBuffer 的用法
            byte[] array = heapBuf.array();
            int offset = heapBuf.arrayOffset() + heapBuf.readerIndex();
            int length = heapBuf.readableBytes();
            System.out.println(Arrays.toString(array));
            System.out.println(offset);
            System.out.println(length);
        }else {
            System.out.println("No Heap Array");
        }*/

        //二.直接缓冲区
        ByteBuf directBuf = Unpooled.directBuffer(100);
        directBuf.writeBytes("direct buffer".getBytes());
        if(!directBuf.hasArray()){
            int length = directBuf.readableBytes();
            byte[] array = new byte[length];
            directBuf.getBytes(directBuf.readerIndex(), array);
            System.out.println(Arrays.toString(array));
            System.out.println(length);
        }
    }
}
