package com.xdf.huangli.test;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.json.JSONArray;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * <p>
 *
 * </P>
 *
 * @author huangli
 * @since 2023-01-16 09:44
 */
public class JDK8GroupTest {
    public static void main(String[] args) {
//        Student s1 = new Student();
//        s1.setSex("男");
//        s1.setAge(12);
//        s1.setName("张三");
//        s1.setStatusFlag(0);
//
//        Student s2 = new Student();
//        s2.setSex("男");
//        s2.setAge(13);
//        s2.setName("张三");
//        s2.setStatusFlag(1);
//
//        Student s3 = new Student();
//        s3.setSex("男");
//        s3.setAge(13);
//        s3.setName("张三");
//        s3.setStatusFlag(1);
//
//        Student s4 = new Student();
//        s4.setSex("男");
//        s4.setAge(13);
//        s4.setName("张三");
//        s4.setStatusFlag(2);
//
//        List<Student> studentList = Arrays.asList(s1, s2, s3, s4);
//        Map<Integer, List<Student>> listMap = studentList.stream().collect(Collectors.groupingBy(Student::getStatusFlag));
//
//        Map<Integer, Integer> integerMap = studentList.stream()
//                .collect(Collectors.groupingBy(Student::getStatusFlag
//                        , Collectors.summingInt(Student::getAge))
//                );
//        System.out.println(JSONObject.toJSON(integerMap));

        String v1 = "V2.1.0";
        String v2 = "V2.2.0";

        System.out.println(v1.compareTo(v2));
    }
}
