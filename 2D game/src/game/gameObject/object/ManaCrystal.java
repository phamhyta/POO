package game.gameObject.object;

import game.gameObject.Player;
import game.math.Vector2f;
import game.render.ObjectRender;

public class ManaCrystal extends GameObject {

	public ManaCrystal(Vector2f origin, int size) {
		super(origin, size);
		type = type_consumable;
		name = "Mana Crystal";
		MP =10;
		objectRender = new ObjectRender(pos, 5, 6,size );
	}

	public void use(Player player) {
		if(player.getMana() + this.MP < player.getMaxMana()) {
			player.setCurrentMana(player.getMana() + this.MP);
		}
		else{
			player.setCurrentMana(player.getMaxMana());
		}
	}

}
