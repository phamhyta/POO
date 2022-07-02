package game.gameObject.object.Items;


import game.gameObject.object.GameObject;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Bow_3 extends GameObject {

	public Bow_3(Vector2f origin, int size){
		super(origin, size);
		type = type_sword;
		name = "Ná điện";
		attackValue = 150;
		coin = 150;
		objectRender = new ObjectRender(pos, 6, 5,size );
	}
}
