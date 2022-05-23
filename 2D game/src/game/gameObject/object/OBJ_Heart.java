package game.gameObject.object;


import game.gameObject.Material;
import game.graphics.SpriteSheet;
import game.math.Vector2f;

import java.awt.*;


public class OBJ_Heart extends Material {

	public OBJ_Heart(Vector2f origin, int size) {
		super(origin, size);
		type = type_pickupOnly;
		name = "Heart";
		HP = 2;
		spriteSheet = new SpriteSheet("/objects/heart_full.png");
		image =  spriteSheet.getSubimage(0,0,size,size);

	}

	@Override
	public void render(Graphics2D g) {

	}

//	public void use(Entity entity) {
//		gp.playSE(2);
//		gp.ui.addMessager("Life +" +value);
//		gp.player.setLife(gp.player.getLife() + value);
//	}
}
