package game.game_object.object.item;


import game.game_object.object.GameObject;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Trig_1 extends GameObject {

	public Trig_1(Vector2f origin, int size){
		super(origin, size);
		type = type_consumable;
		name = "Nhẫn vàng";
		speed = 5;
		coin = 50;
		objectRender = new ObjectRender(pos, 8, 4,size );
	}
}
