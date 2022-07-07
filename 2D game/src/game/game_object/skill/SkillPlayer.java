package game.game_object.skill;

import game.data.GameControl;
import game.game_object.Player;

public class SkillPlayer extends Skill{
    public SkillPlayer(Player player, int size) {
        super(player, size);
        type =SKILL_PLAYER;
        checkCurrentDirection();
    }

    public void update(){
        super.update();
        for(int i = 0; i< GameControl.enemy.length; i++){
            if(GameControl.enemy[i] != null){
                if(this.getBounds().collides(GameControl.enemy[i].getBounds())){
                    die = true;
                    GameControl.enemy[i].setHealth( GameControl.enemy[i].getHealth()- damageCaculate( GameControl.enemy[i]), force*getDirection(), currentDirection == UP || currentDirection == DOWN);
                    if(GameControl.enemy[i].getHealth() <= 0) GameControl.enemy[i].setDeath(true);
                }
            }
        }
    }
    private void checkCurrentDirection() {
        if(direction == UP) up =true;
        if(direction == DOWN) down =true;
        if(direction == LEFT) left =true;
        if(direction == RIGHT) right =true;
    }

}
