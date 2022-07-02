package game.gameObject.object;


import game.math.Vector2f;
import game.render.ObjectRender;


public class Futility_1 extends GameObject {

	public Futility_1(Vector2f origin, int size){
		super(origin, size);
		name = "Nang lợn";
		coin = 1000;
		objectRender = new ObjectRender(pos, 17, 9,size );
	}
}
