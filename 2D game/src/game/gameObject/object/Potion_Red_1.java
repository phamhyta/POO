package game.gameObject.object;

import game.gameObject.Player;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Potion_Red_1 extends GameObject {

	public Potion_Red_1(Vector2f origin, int size) {
		super(origin, size);
		type= type_consumable;
		name = "Red Potion";
		HP = 50;
		coin = 50;
		objectRender = new ObjectRender(pos, 9, 0,size );
	}

	public void use(Player player) {
		if(player.getMana() + this.HP < player.getMaxHealth()) {
			player.setHealth(player.getHealth() + this.HP);
		}
		else{
			player.setHealth(player.getMaxHealth());
		}
	}


}
