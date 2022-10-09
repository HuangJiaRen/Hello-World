package com.xdf.huangli.strategy;

/**
 * <p>
 *  默认的俄罗斯方块，实现Game
 * </P>
 *
 * @author huangli
 * @since 2022-06-14 10:34
 */
public class Default implements Game {
    @Override
    public void play() {
        System.out.println("游戏：俄罗斯方块...playing");
    }

    @Override
    public void uninstall() {
        System.out.println("游戏：俄罗斯方块...卸载");
    }
}
