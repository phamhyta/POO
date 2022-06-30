package game.gameObject.object;

import game.gameObject.Player;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Food_6 extends GameObject {

	public Food_6(Vector2f origin, int size) {
		super(origin, size);
		type= type_consumable;
		name = "Đùi gà";
		HP = 50;
        coin = 50;
		objectRender = new ObjectRender(pos, 15, 0,size );
	}

	public void use(Player player) {
		
	}


}

