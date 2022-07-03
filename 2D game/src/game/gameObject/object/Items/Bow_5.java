package game.gameObject.object.items;


import game.gameObject.object.GameObject;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Bow_5 extends GameObject {

	public Bow_5(Vector2f origin, int size){
		super(origin, size);
		type = type_sword;
		name = "Trượng quyền năng";
		attackValue = 250;
		coin = 250;
		objectRender = new ObjectRender(pos, 6, 7,size );
	}
}
