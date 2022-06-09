package game.render;

import game.gameObject.Entity;
import game.gameObject.Player;
import game.graphics.SpriteSheet;

import java.awt.*;

public class PlayerRender extends EntityRender {
    private Player player;

    public PlayerRender(Player player, SpriteSheet spriteSheet){
        super(player,spriteSheet);
        this.player = player;

        ani.setNumFrames(4, UP);
        ani.setNumFrames(4, DOWN);
        ani.setNumFrames(4, ATTACK + RIGHT);
        ani.setNumFrames(4, ATTACK + LEFT);
        ani.setNumFrames(4, ATTACK + UP);
        ani.setNumFrames(4, ATTACK + DOWN);

    }

    @Override
    public void update() {
        super.update();
        if(player.isFallen() && ani.hasPlayedOnce() ){
            setAnimation(RIGHT, spriteSheet.getSpriteArray(RIGHT), 10);
        }
    }

    public void render(Graphics2D g) {
        g.setColor(Color.green);
        g.drawRect((int) (player.getPos().getWorldVar().x + player.getBounds().getXOffset()),(int)(player.getPos().getWorldVar().y+ player.getBounds().getYOffset()),
                (int) player.getBounds().getWidth(), (int) player.getBounds().getHeight());
        if(player.isAttack()){
            g.setColor(Color.red);
            g.drawRect((int) (player.getHitBounds().getPos().getWorldVar().x + player.getHitBounds().getXOffset()),(int)(player.getHitBounds().getPos().getWorldVar().y+ player.getHitBounds().getYOffset()),
                    (int) player.getHitBounds().getWidth(), (int) player.getHitBounds().getHeight());
        }

        g.drawImage(ani.getImage().image,(int) (player.getPos().getWorldVar().x),(int)(player.getPos().getWorldVar().y), player.getSize(), player.getSize(),null);
    }
}
