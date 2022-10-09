package com.xdf.huangli.strategy;

/**
 * <p>
 *
 * </P>
 *
 * @author huangli
 * @since 2022-06-14 10:35
 */
public class PlayContext {
    private Game game;

    public PlayContext(){
        this.game = new Default();
    }

    public PlayContext(Game game){
        // 这里根据传入的具体实例赋值
        this.game = game;
    }

    public void trigger(){
        // 这里是对行为的封装，只提供play方法的触发
        this.game.play();
    }
}
