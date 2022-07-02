package game.gameObject.object.Items;


import game.gameObject.object.GameObject;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Trig_2 extends GameObject {

	public Trig_2(Vector2f origin, int size){
		super(origin, size);
		type = type_consumable;
		name = "Nhẫn vàng pro";
		speed = 6;
		coin = 60;
		objectRender = new ObjectRender(pos, 8, 5,size );
	}
}
