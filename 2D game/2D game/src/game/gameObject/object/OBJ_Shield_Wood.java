package game.gameObject.object;


import game.gameObject.Material;
import game.graphics.SpriteSheet;
import game.math.Vector2f;

import java.awt.*;


public class OBJ_Shield_Wood extends Material {

	public OBJ_Shield_Wood(Vector2f origin, int size) {
		super(origin, size);
		type= type_shield;
		name = "Wood Shield";
		spriteSheet = new SpriteSheet("/objects/shield_wood.png");
		image =  spriteSheet.getSubimage(0,0,size,size);

		defense =1;
//		description= "["+ name +"]\nMade by wood.";
	}

	@Override
	public void render(Graphics2D g) {

	}
}
