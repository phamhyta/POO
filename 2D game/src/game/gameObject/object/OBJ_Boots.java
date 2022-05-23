package game.gameObject.object;


import game.gameObject.Material;
import game.graphics.SpriteSheet;
import game.math.Vector2f;

import java.awt.*;


public class OBJ_Boots extends Material {

	public OBJ_Boots(Vector2f origin, int size){
		super(origin, size);

		name = "Boots";
		spriteSheet = new SpriteSheet("/objects/boots.png");
		image =  spriteSheet.getSubimage(0,0,size,size);

		speed =4;
	}

	@Override
	public void render(Graphics2D g) {

	}
}
