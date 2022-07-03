package game.render;

import game.game_object.skill.Skill;
import game.graphics.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferedImage;

public
class SkillRender{
    private SpriteSheet arrow;
    private BufferedImage rock;
    private Skill skill;

    public SkillRender (Skill skill){
        this.skill = skill;
        arrow = new SpriteSheet("res/entity/arrow.png",1024,256);
        rock = new SpriteSheet("res/entity/rock.png",16,16).getSprite(0,0).image;
    }
    public void render(Graphics2D g){
        if(skill.getType() == Skill.SKILL_PLAYER){
            if(skill.isUp()) {
                g.drawImage( arrow.getSubimage(0,0,256,256), (int)skill.getPos().getWorldVar().x,(int)skill.getPos().getWorldVar().y,64,64,null);
            }
            if(skill.isLeft()) {
                g.drawImage( arrow.getSubimage(256,0,256,256), (int)skill.getPos().getWorldVar().x,(int)skill.getPos().getWorldVar().y,64,64,null);
            }
            if(skill.isRight()) {
                g.drawImage( arrow.getSubimage(768,0,256,256), (int)skill.getPos().getWorldVar().x,(int)skill.getPos().getWorldVar().y,64,64,null);
            }
            if(skill.isDown()) {
                g.drawImage( arrow.getSubimage(512,0,256,256), (int)skill.getPos().getWorldVar().x,(int)skill.getPos().getWorldVar().y,64,64,null);
            }
        }
        if(skill.getType() == Skill.SKILL_BOSS){
                g.drawImage(rock,(int)skill.getPos().getWorldVar().x,(int)skill.getPos().getWorldVar().y,48,48,null);
        }
    }
}

