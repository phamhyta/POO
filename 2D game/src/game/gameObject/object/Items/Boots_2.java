package game.gameObject.object.items;


import game.gameObject.object.GameObject;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Boots_2 extends GameObject {

	public Boots_2(Vector2f origin, int size){
		super(origin, size);
		type = type_shield;
		name = "Giày Bạc";
		speed = 10;
		coin = 100;
		objectRender = new ObjectRender(pos, 8, 3,size );
	}
}
