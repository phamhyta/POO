package game.gameObject.object;


import game.gameObject.Material;
import game.graphics.SpriteSheet;
import game.math.Vector2f;

import java.awt.*;


public class OBJ_Key extends Material {

	public OBJ_Key(Vector2f origin, int size) {
		super(origin, size);
		name = "Key";

		spriteSheet = new SpriteSheet("/objects/key.png");
		image =  spriteSheet.getSubimage(0,0,size,size);
//		description= "["+ name +"]\nIt opens a door.";
	}

	@Override
	public void render(Graphics2D g) {

	}
}
