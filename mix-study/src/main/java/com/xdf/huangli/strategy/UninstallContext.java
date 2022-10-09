package com.xdf.huangli.strategy;

/**
 * <p>
 *  用来维护uninstall这个算法的实现
 * </P>
 *
 * @author huangli
 * @since 2022-06-14 10:37
 */
public class UninstallContext {
    private Game game;

    public UninstallContext(){
        this.game = new Default();
    }

    public UninstallContext(Game game){
        // 这里根据传入的具体实例赋值
        this.game = game;
    }

    public void trigger(){
        // 这里是对行为的封装，只提供uninstall方法的触发
        this.game.uninstall();
    }
}
