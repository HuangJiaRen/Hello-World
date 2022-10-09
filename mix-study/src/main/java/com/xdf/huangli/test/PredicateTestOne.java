package com.xdf.huangli.test;

import java.util.function.Predicate;

/**
 * <p>
 *我们来验证一下，那说的比较矛盾的地方。
 *  * 1. 评估参数里面的表达式(说白了就是验证传进来的参数符不符合规则,后面有例子)
 *  *    我们来验证一下这句话，并且解释一下。
 * </P>
 *
 * @author huangli
 * @since 2021-05-07 09:02
 */

public class PredicateTestOne {

    public static void main(String[] args) {

        PredicateTestOne predicateTestOne = new PredicateTestOne();

        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {

                return s.equals("zhangsan");
            }
        };

        System.out.println(predicate.test("lisi"));
        System.out.println("--- --- --- --- --- ---");
        System.out.println(predicate.test("zhangsan"));
    }
}

