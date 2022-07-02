package game.gameObject.object;


import game.math.Vector2f;
import game.render.ObjectRender;


public class Shield_2 extends GameObject {

	public Shield_2(Vector2f origin, int size){
		super(origin, size);
		type = type_shield;
		name = "Khiên bạc";
		defense = 100;
		coin = 100;
		objectRender = new ObjectRender(pos, 6, 1,size );
	}
}
