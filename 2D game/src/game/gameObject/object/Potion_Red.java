package game.gameObject.object;

import game.gameObject.Player;
import game.math.Vector2f;


public class Potion_Red extends GameObject {

	public Potion_Red(Vector2f origin, int size) {
		super(origin, size);
		type= type_consumable;
		name = "Red Potion";
		HP =50;
		objectRender = new ObjectRender(pos, 2, 3,size );
	}

	public void use(Player player) {
		if(player.getHealth() + this.HP < player.getMaxHealth()) {
			player.setHealth(player.getHealth() + this.HP);
		}
		else{
			player.setHealth(player.getMaxHealth());
		}
	}


}
