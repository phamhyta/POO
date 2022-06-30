package game.gameObject.object;

import game.gameObject.Player;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Sword_5 extends GameObject {

	public Sword_5(Vector2f origin, int size) {
		super(origin, size);
		type= type_sword;
		name = "Thủ kiếm";
		attackValue = 250;
        coin = 250;
		objectRender = new ObjectRender(pos, 5, 4,size );
	}

	public void use(Player player) {
		
	}


}
