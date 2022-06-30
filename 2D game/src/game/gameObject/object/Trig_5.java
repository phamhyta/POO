package game.gameObject.object;


import game.math.Vector2f;
import game.render.ObjectRender;


public class Trig_5 extends GameObject {

	public Trig_5(Vector2f origin, int size){
		super(origin, size);
		type = type_consumable;
		name = "Nanh bạc";
		speed = 9;
		coin = 90;
		objectRender = new ObjectRender(pos, 8, 8,size );
	}
}
