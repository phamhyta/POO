package game.gameObject.object;

import game.gameObject.Player;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Potion_Red_3 extends GameObject {

	public Potion_Red_3(Vector2f origin, int size) {
		super(origin, size);
		type= type_consumable;
		name = "Red Potion Pro vip";
		MP = 150;
		coin = 150;
		objectRender = new ObjectRender(pos, 9, 8,size );
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
