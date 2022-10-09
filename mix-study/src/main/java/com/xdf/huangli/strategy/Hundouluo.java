package com.xdf.huangli.strategy;

/**
 * <p>
 *   魂斗罗，实现Game
 * </P>
 *
 * @author huangli
 * @since 2022-06-14 10:33
 */
public class Hundouluo implements Game {
    @Override
    public void play() {
        System.out.println("游戏：魂斗罗...playing");
    }

    @Override
    public void uninstall() {
        System.out.println("游戏：魂斗罗...卸载");
    }
}
