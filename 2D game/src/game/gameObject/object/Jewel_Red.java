
package game.gameObject.object;

import game.gameObject.Player;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Jewel_Red extends GameObject {

	public Jewel_Red(Vector2f origin, int size) {
		super(origin, size);
		type= type_consumable;
		name = "Red Jewel";
		MP = 150;
		coin = 150;
		objectRender = new ObjectRender(pos, 18, 1,size );
	}

	public void use(Player player) {
		
	}


}
