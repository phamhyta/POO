
package game.gameObject.object.Items;

import game.gameObject.Player;
import game.gameObject.object.GameObject;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Book_Blue extends GameObject {

	public Book_Blue(Vector2f origin, int size) {
		super(origin, size);
		type= type_consumable;
		name = "Blue Book";
		MP = 100;
        coin = 100;
		objectRender = new ObjectRender(pos, 13, 0,size );
	}

}
