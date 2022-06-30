package game.gameObject.object;

import game.gameObject.Player;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Sword_6 extends GameObject {

	public Sword_6(Vector2f origin, int size) {
		super(origin, size);
		type= type_sword;
		name = "Cổ kiếm";
		attackValue = 300;
        coin = 300;
		objectRender = new ObjectRender(pos, 5, 5,size );
	}

	public void use(Player player) {
		
	}


}
