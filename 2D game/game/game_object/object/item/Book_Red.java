
package game.game_object.object.item;

import game.game_object.object.GameObject;
import game.math.Vector2f;
import game.render.ObjectRender;


public class Book_Red extends GameObject {

	public Book_Red(Vector2f origin, int size) {
		super(origin, size);
		type= type_consumable;
		name = "Red Book";
		MP = 100;
		coin = 100;
		objectRender = new ObjectRender(pos, 13, 1,size );
	}

}
