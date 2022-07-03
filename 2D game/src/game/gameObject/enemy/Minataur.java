package game.gameObject.enemy;

import game.data.GameControl;
import game.gameObject.object.Items.Coin;
import game.gameObject.object.Items.Potion_Blue_1;
import game.gameObject.object.Items.Potion_Red_1;
import game.gameObject.object.Items.Shield_2;
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

        hasIdle = true;
        useRight = true;
        right = true;
    }
    public void drop() {
//        GameControl.setGameObject(new Coin((new Vector2f(this.getPos().x, this.getPos().y)), 32, this.coin));
//        GameControl.setGameObject(new Potion_Blue_1(new Vector2f(this.getPos().x - 50, this.getPos().y), 32));
//        GameControl.setGameObject(new Potion_Red_1(new Vector2f(this.getPos().x - 20, this.getPos().y), 32));
//        GameControl.setGameObject(new Shield_2(new Vector2f(this.getPos().x - 40, this.getPos().y), 32));
        int rand = (int) (Math.random() * 100);
        if (rand < 30) {
            GameControl.setGameObject(new Potion_Red_1(new Vector2f(this.getPos().x - 50, this.getPos().y), 32));
        } else if (rand < 35 && rand >= 15) {
            GameControl.setGameObject(new Potion_Blue_1(new Vector2f(this.getPos().x + 25, this.getPos().y), 32));
        } else if (rand >= 50 && rand <= 75) {
            GameControl.setGameObject(new Potion_Red_1(new Vector2f(this.getPos().x - 50, this.getPos().y), 32));
            GameControl.setGameObject(new Potion_Blue_1(new Vector2f(this.getPos().x + 25, this.getPos().y), 32));
            GameControl.setGameObject(new Shield_2(new Vector2f(this.getPos().x - 40, this.getPos().y), 32));
        } else if (rand >= 35 && rand < 50) {
            GameControl.setGameObject(new Shield_2(new Vector2f(this.getPos().x - 40, this.getPos().y), 32));
            GameControl.setGameObject(new Potion_Red_1(new Vector2f(this.getPos().x - 50, this.getPos().y), 32));
        }
    }
}
