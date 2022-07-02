package game.gameObject.object.Items;


import game.gameObject.object.GameObject;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Trig_4 extends GameObject {

	public Trig_4(Vector2f origin, int size){
		super(origin, size);
		type = type_consumable;
		name = "Tràng hạt";
		speed = 8;
		coin = 80;
		objectRender = new ObjectRender(pos, 8, 7,size );
	}
}
