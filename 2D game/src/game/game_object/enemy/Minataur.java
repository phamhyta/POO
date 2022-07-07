package game.game_object.enemy;

import game.data.GameControl;

import game.game_object.object.item.Potion_Blue_3;
import game.game_object.object.item.Potion_Red_3;
import game.game_object.object.item.Shield_2;
import game.game_object.object.item.Sword_5;
import game.math.Vector2f;

public class Minataur extends Enemy {
    public Minataur(Vector2f origin, int size) {
        super(origin, size);
        xOffset = size / 4;
        yOffset = size / 4;
        maxHealth= 200;
        health= 200;
        EXP =30;
        damage = 30;
        acc = 1f;
        deacc = 2f;
        maxSpeed = 2f;
        r_sense = 700;
        r_attackrange = 32;
        coin =10;
        dropRate=0.8F;

        hasIdle = true;
        useRight = true;
        right = true;
    }
    public void drop() {
        int rand = (int) (Math.random() * 100 /dropRate);
        if (rand < 50 && rand >=0) {
            GameControl.setGameObject(new Potion_Red_3(new Vector2f(this.getPos().x - 50, this.getPos().y+5), 32));
        } else if (rand < 80 && rand >= 50) {
            GameControl.setGameObject(new Potion_Blue_3(new Vector2f(this.getPos().x + 25, this.getPos().y-5), 32));
        } else if (rand >= 80 && rand <= 95) {
            GameControl.setGameObject(new Shield_2(new Vector2f(this.getPos().x - 40, this.getPos().y+10), 32));
        }
        else {
            GameControl.setGameObject(new Sword_5(new Vector2f(this.getPos().x , this.getPos().y), 32));
        }
    }
}
