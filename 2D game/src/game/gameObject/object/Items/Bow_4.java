package game.gameObject.object.Items;


import game.gameObject.object.GameObject;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Bow_4 extends GameObject {

	public Bow_4(Vector2f origin, int size){
		super(origin, size);
		type = type_sword;
		name = "Boomerang";
		attackValue = 200;
		coin = 200;
		objectRender = new ObjectRender(pos, 6, 6,size );
	}
}