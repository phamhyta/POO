package game.gameObject.object;


import game.gameObject.GameObject;
import game.graphics.SpriteSheet;
import game.math.Vector2f;

import java.awt.*;


public class OBJ_Sworld_Normal extends GameObject {


	public OBJ_Sworld_Normal(Vector2f origin, int size) {
		super(origin, size);
		type= type_sword;
		name = "Normal Sword";
		spriteSheet = new SpriteSheet("/objects/shield_normal.png");
		image =  spriteSheet.getSubimage(0,0,size,size);
		attackValue =1;
//		attackArea.width=36;
//		attackArea.height=36;
//		description= "["+ name +"]\nAn old sword.";
	}

	@Override
	public void render(Graphics2D g) {

	}
}
