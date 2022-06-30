package game.gameObject.object;

import game.gameObject.Player;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Potion_Red extends GameObject {

	public Potion_Red(Vector2f origin, int size) {
		super(origin, size);
		type= type_pickupOnly;
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