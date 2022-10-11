package com.xdf.huangli.jdk8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @uthor huangli
 * @description
 * @date 2019/4/18 10:00
 */
public class CollectorsTest {
    public static void main(String[] args) {
        testToCollection();

//        test();
    }

    private static void testToCollection() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        Map<String, Integer> integerMap = list.stream().map(a -> a * 10).collect(Collectors.toMap(key -> "k" + key, value -> value));
        List<Integer> integers = list.stream().filter(l -> l != 10).collect(Collectors.toList());

        List<Student> studentList = Arrays.asList(new Student("张三", 10), new Student("李四", 20));

        // [10, 20, 30]
        List<Integer> collect = list.stream().map(i -> i * 10).collect(Collectors.toList());
        System.out.println("collect输出值：");
        for (Integer integer : collect) {
            System.out.println(integer);
        }

        List<Student> students = studentList.stream().filter(student -> student.getName().equals("李四")).collect(Collectors.toList());


        // [20, 10, 30]
        Set<Integer> collect1 = list.stream().map(i -> i * 10).collect(Collectors.toSet());
        System.out.println("collect1输出值：");
        collect1.forEach(integer -> {
            System.out.println(integer);
        });

        // {key1=value:10, key2=value:20, key3=value:30}
        Map<String, String> collect2 = list.stream().map(i -> i * 10).collect(Collectors.toMap(key -> "key" + key/10, value -> "value:" + value));
        System.out.println("collect2输出值：");
        collect2.forEach((k,v)->{
            System.out.println(k + ":" + v);
        });

        Map<Object, Student> studentMap = studentList.stream().collect(Collectors.toMap(Student::getAge, student -> student));
        System.out.println("studentMap输出值：");
        studentMap.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });

        // [1, 3, 4]
        TreeSet<Integer> collect3= Stream.of(1, 3, 4).collect(Collectors.toCollection(TreeSet::new));
        System.out.println("collect3输出值：");
        collect3.forEach(integer -> {
            System.out.println(integer);
        });
    }


    private static void test() {
        List<Student> studentList = Arrays.asList(new Student("张三", 10), new Student("李四", 20));
        // 求最值 3
        List<Integer> list = Arrays.asList(1, 2, 3);
        Integer maxValue = list.stream().collect(Collectors.collectingAndThen(Collectors.maxBy((a, b) -> a - b), Optional::get));


        // 最小值 1
        Integer minValue = list.stream().collect(Collectors.collectingAndThen(Collectors.minBy((a, b) -> a - b), Optional::get));

        // 求和 6
        Integer sumValue = list.stream().collect(Collectors.summingInt(item -> item));

        Long ageCount = studentList.stream().collect(Collectors.summingLong(Student::getAge));

        // 平均值 2.0
        Double avg = list.stream().collect(Collectors.averagingDouble(x -> x));
    }

}
