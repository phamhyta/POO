package game.game_object.object.item;


import game.game_object.object.GameObject;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Shield_3 extends GameObject {

	public Shield_3(Vector2f origin, int size){
		super(origin, size);
		type = type_shield;
		name = "Khiên pro";
		defense = 150;
		coin = 150;
		objectRender = new ObjectRender(pos, 6, 2,size );
	}
}
