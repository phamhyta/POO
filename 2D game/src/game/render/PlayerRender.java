package game.render;

import game.gameObject.Player;
import game.graphics.Animation;
import game.graphics.SpriteSheet;
import game.util.Camera;

public class PlayerRender extends EntityRender {
    private Player player;

    public PlayerRender(Camera camera,Player player, SpriteSheet spriteSheet){
        super(camera,player,spriteSheet);
        this.player = player;

        ani.setNumFrames(4, ATTACK + RIGHT);
        ani.setNumFrames(4, ATTACK + LEFT);
        ani.setNumFrames(4, ATTACK + UP);
        ani.setNumFrames(4, ATTACK + DOWN);

    }


}
