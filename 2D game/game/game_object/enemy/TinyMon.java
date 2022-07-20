package game.game_object.enemy;

import game.data.GameControl;

import game.game_object.object.item.Potion_Blue_2;
import game.game_object.object.item.Potion_Red_2;
import game.game_object.object.item.Shield_2;
import game.game_object.object.item.Sword_3;
import game.math.Vector2f;

public class TinyMon extends Enemy {

    public TinyMon(Vector2f origin, int size) {
        super( origin, size);
        maxHealth= 100;
        health= 100;
        damage = 20;
        acc = 1f;
        deacc = 2f;
        maxSpeed = 2f;
        r_sense = 500;
        r_attackrange = 32;
        r_enemyArea= 1000;
        EXP=20;
        coin = 5;
        dropRate=1;
    }
    public void drop() {
        int rand = (int) (Math.random() * 100 /dropRate);
        if (rand < 50 && rand >=0) {
            GameControl.setGameObject(new Potion_Red_2(new Vector2f(this.getPos().x - 50, this.getPos().y+5), 32));
        } else if (rand < 80 && rand >= 50) {
            GameControl.setGameObject(new Potion_Blue_2(new Vector2f(this.getPos().x + 25, this.getPos().y-5), 32));
        } else if (rand >= 80 && rand <= 95) {
            GameControl.setGameObject(new Shield_2(new Vector2f(this.getPos().x - 40, this.getPos().y+10), 32));
        }
        else {
            GameControl.setGameObject(new Sword_3(new Vector2f(this.getPos().x , this.getPos().y), 32));
        }
    }
}
