package game.gameObject.object;

import game.gameObject.Player;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Sword_2 extends GameObject {

	public Sword_2(Vector2f origin, int size) {
		super(origin, size);
		type= type_sword;
		name = "Bạch Kiếm";
		attackValue = 100;
		coin = 100;
		objectRender = new ObjectRender(pos, 5, 1,size );
	}

	public void use(Player player) {
		
	}


}

