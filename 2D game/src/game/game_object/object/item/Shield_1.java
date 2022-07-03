package game.game_object.object.item;


import game.game_object.object.GameObject;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Shield_1 extends GameObject {

	public Shield_1(Vector2f origin, int size){
		super(origin, size);
		type = type_shield;
		name = "Khiên";
		defense = 50;
		coin = 50;
		objectRender = new ObjectRender(pos, 6, 0,size );
	}
}
