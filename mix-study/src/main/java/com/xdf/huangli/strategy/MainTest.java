package com.xdf.huangli.strategy;

/**
 * <p>
 *
 * </P>
 *
 * @author huangli
 * @since 2022-06-14 10:43
 */
public class MainTest {
    public static void main(String[] args) {
        new PlayContext(new Hundouluo()).trigger();
        new UninstallContext(new Hundouluo()).trigger();
    }
}
