package game.gameObject.object.items;


import game.gameObject.object.GameObject;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Trig_6 extends GameObject {

	public Trig_6(Vector2f origin, int size){
		super(origin, size);
		type = type_consumable;
		name = "Balo";
		speed = 10;
		coin = 100;
		objectRender = new ObjectRender(pos, 8, 9,size );
	}
}
