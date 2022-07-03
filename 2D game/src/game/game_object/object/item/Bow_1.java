package game.game_object.object.item;


import game.game_object.object.GameObject;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Bow_1 extends GameObject {

	public Bow_1(Vector2f origin, int size){
		super(origin, size);
		type = type_sword;
		name = "Cung gỗ";
		attackValue = 50;
		coin = 50;
		objectRender = new ObjectRender(pos, 6, 3,size );
	}
}
