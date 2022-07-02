package game.gameObject.object;

import game.gameObject.Player;
import game.math.Vector2f;
import game.render.ObjectRender;

public class Coin extends GameObject {

	public Coin(Vector2f origin, int size, int value) {
		super(origin, size);
		this.coin = value;
		type= type_consumable;
		name = "Bronze Coin";
		objectRender = new ObjectRender(pos, 10, 2,size );
	}

	public void use(Player player) {
		player.setCoin( player.getCoin() + this.coin);
	}
}
