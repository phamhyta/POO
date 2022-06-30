
package game.gameObject.object;

import game.gameObject.Player;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Jewel_Blue extends GameObject {

	public Jewel_Blue(Vector2f origin, int size) {
		super(origin, size);
		type= type_consumable;
		name = "Blue Jewel";
		MP = 150;
		coin = 150;
		objectRender = new ObjectRender(pos, 18, 0,size );
	}
}
