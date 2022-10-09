package com.xdf.huangli.strategy;

/**
 * <p>
 *  马戏团，实现Game
 * </P>
 *
 * @author huangli
 * @since 2022-06-14 10:33
 */
public class Maxituan implements Game {
    @Override
    public void play() {
        System.out.println("游戏：马戏团...playing");
    }

    @Override
    public void uninstall() {
        System.out.println("游戏：马戏团...卸载");
    }

}
