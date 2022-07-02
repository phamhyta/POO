package game.gameObject.object;


import game.math.Vector2f;
import game.render.ObjectRender;


public class Bow_2 extends GameObject {

	public Bow_2(Vector2f origin, int size){
		super(origin, size);
		type = type_sword;
		name = "Nỏ sét";
		attackValue = 100;
		coin = 100;
		objectRender = new ObjectRender(pos, 6, 4,size );
	}
}
