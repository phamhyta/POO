package game.gameObject.object;


import game.gameObject.GameObject;
import game.graphics.SpriteSheet;
import game.math.Vector2f;

import java.awt.*;


public class OBJ_Shield_Blue extends GameObject {

	public OBJ_Shield_Blue(Vector2f origin, int size) {
		super(origin, size);
		type= type_shield;

		name = "Blue Shield";

		spriteSheet = new SpriteSheet("/objects/shield_blue.png");
		image =  spriteSheet.getSubimage(0,0,size,size);
		defense =2;
//		description= "["+ name +"]\nA shiny blue shield.";

	}

	@Override
	public void render(Graphics2D g) {

	}
}
