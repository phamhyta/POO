package game.gameObject.object;

import game.gameObject.Player;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Potion_Blue_2 extends GameObject {

	public Potion_Blue_2(Vector2f origin, int size) {
		super(origin, size);
		type= type_consumable;
		name = "Blue Potion pro";
		MP = 100;
		coin = 100;
		objectRender = new ObjectRender(pos, 9, 5,size );
	}

	public void use(Player player) {
		// if(player.getHealth() + this.HP < player.getMaxHealth()) {
		// 	player.setHealth(player.getHP() + this.MP);
		// }
		// else{
		// 	player.setHealth(player.getMaxHealth());
		// }
	}


}
