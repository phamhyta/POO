package game.game_object.object.item;


import game.game_object.object.GameObject;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Futility_2 extends GameObject {

	public Futility_2(Vector2f origin, int size){
		super(origin, size);
		name = "Lông gà";
		coin = 1000;
		objectRender = new ObjectRender(pos, 17, 10,size );
	}
}
