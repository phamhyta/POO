package game.gameObject.object.Items;


import game.gameObject.object.GameObject;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Boots_1 extends GameObject {

	public Boots_1(Vector2f origin, int size){
		super(origin, size);
		type = type_shield;
		name = "Giày";
		speed = 5;
		coin = 50;
		objectRender = new ObjectRender(pos, 8, 2,size );
	}
}
