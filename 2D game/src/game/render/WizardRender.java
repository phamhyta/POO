package game.render;

import game.game_object.enemy.Wizard_BOSS;
import game.graphics.SpriteSheet;

import java.awt.*;

public class WizardRender  extends EntityRender{
    private Wizard_BOSS wiz;
    public WizardRender( Wizard_BOSS wiz, SpriteSheet spriteSheet) {
        super(wiz, spriteSheet);
        this.wiz = wiz;

        ATTACK_DOWN = 0;
        ATTACK_UP = 0;
        ATTACK_LEFT = 1;
        ATTACK_RIGHT = 0;
        SKILL_UP=0;
        SKILL_DOWN=0;
        SKILL_LEFT=0;
        SKILL_RIGHT=0;
        FALLEN = 0;
        UP = 0;
        DOWN = 0;
        LEFT = 0;
        RIGHT = 0;
        IDLE =2;


        ani.setNumFrames(10, 0);
        currentAnimation = 0;
    }

    @Override
    public void render(Graphics2D g) {

            if(wiz.useRight && wiz.isLeft()) {
                g.drawImage(ani.getImage().image, (int) (wiz.getPos().getWorldVar().x) + wiz.getSize(), (int) (wiz.getPos().getWorldVar().y ), -wiz.getSize(), wiz.getSize(), null);
            } else {
                g.drawImage(ani.getImage().image, (int) (wiz.getPos().getWorldVar().x), (int) (wiz.getPos().getWorldVar().y), wiz.getSize(), wiz.getSize(), null);
            }

            // Health Bar
            g.setColor(Color.red);
            g.fillRect((int) (wiz.getPos().getWorldVar().x + 20), (int) (wiz.getPos().getWorldVar().y ), 24, 5);

            g.setColor(Color.green);
            g.fillRect((int) (wiz.getPos().getWorldVar().x + 20), (int) (wiz.getPos().getWorldVar().y ), (int) (24 * wiz.getHealthPercent()), 5);

            for (int i = 0; i < entity.getSkill().size(); i++) {
            if (entity.getSkill().get(i) != null)
                entity.getSkill().get(i).getSkillRender().render(g);
        }
    }
}
