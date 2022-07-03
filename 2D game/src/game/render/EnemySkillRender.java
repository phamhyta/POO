package game.render;

import game.gameObject.skill.EnemySkill;
import game.graphics.SpriteSheet;

import java.awt.*;

public
class EnemySkillRender {
    private SpriteSheet arrow;
    private EnemySkill skill;

    public EnemySkillRender(EnemySkill skill){
        this.skill = skill;
        arrow = new SpriteSheet("res/entity/arrow.png",1024,256);

    }
    public void render(Graphics2D g){
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
}

