package game.game_object.object.item;


import game.game_object.object.GameObject;
import game.math.Vector2f;


public class Heart extends GameObject {

	public Heart(Vector2f origin, int size) {
		super(origin, size);
		type = type_pickupOnly;
		name = "Heart";
		HP = 100;
	}
}
