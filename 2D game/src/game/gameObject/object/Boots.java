package game.gameObject.object;


import game.math.Vector2f;


public class Boots extends GameObject {

	public Boots(Vector2f origin, int size){
		super(origin, size);

		name = "Boots";
		objectRender = new ObjectRender(new Vector2f(pos.getWorldVar().x, pos.getWorldVar().y), 8, 9,size );
		speed =4;
	}
}
