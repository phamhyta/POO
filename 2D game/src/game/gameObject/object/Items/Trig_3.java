package game.gameObject.object.Items;


import game.gameObject.object.GameObject;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Trig_3 extends GameObject {

	public Trig_3(Vector2f origin, int size){
		super(origin, size);
		type = type_consumable;
		name = "Dây chuyền vàng";
		speed = 7;
		coin = 70;
		objectRender = new ObjectRender(pos, 8, 6,size );
	}
}
