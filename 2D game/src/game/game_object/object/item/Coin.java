package game.game_object.object.item;

import game.game_object.Player;
import game.game_object.object.GameObject;
import game.math.Vector2f;
import game.render.ObjectRender;

public class Coin extends GameObject {

	public Coin(Vector2f origin, int size, int value) {
		super(origin, size);
		this.coin = value;
		type= type_consumable;
		name = "Bronze Coin";
		objectRender = new ObjectRender(pos, 12, 7,size );
	}

	public void use(Player player) {
		player.setCoin( player.getCoin() + this.coin);
	}
}
