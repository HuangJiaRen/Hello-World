package com.xdf.huangli.loadbalance;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>
 * 权重算法-加权轮询算法
 * </P>
 *
 * @author huangli
 * @since 2021-03-27 21:56
 */
public class WeightPollIng {
    /**
     * key是ip,value是权重值
     */
    public static Map<String, Integer> ipMap = new LinkedHashMap<>();
    static {
        ipMap.put("192.168.1.1", 3);
        ipMap.put("192.168.1.2", 2);
        ipMap.put("192.168.1.3", 1);
    }
    public static int requestId = 0;
    public static int getAndIncrement(){
        return requestId ++;
    }

    public static String getIp(){
        //获取总权重
        int weightTotal = 0;
        for (Integer value : ipMap.values()){
            weightTotal += value;
        }
        //获取当前轮询的值
        int andIncrement = getAndIncrement();
        int pos = andIncrement % weightTotal;
        for (String ip : ipMap.keySet()){
            if(pos < ipMap.get(ip)){
                return ip;
            }
            pos -= ipMap.get(ip);
        }

        return null;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getIp());
        }
    }
}
