package com.xdf.huangli.loadbalance;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * 轮询算法
 * https://www.jb51.net/article/178868.htm
 * </P>
 *
 * @author huangli
 * @since 2021-03-27 21:34
 */
public class PollDemo {
    /**
     * key是ip
     */
    public static List<String> ipList = new LinkedList<>();
    static {
        ipList.add("192.168.1.1");
        ipList.add("192.168.1.2");
        ipList.add("192.168.1.3");
    }
    public static int pos = 0;
    public static String getIp(){
        if(pos >= ipList.size()){
            //防止索引越界
            pos = 0;
        }
        String ip = ipList.get(pos);
        pos ++;
        return ip;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(getIp());
        }
    }
}
