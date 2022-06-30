package game.gameObject.object;


import game.math.Vector2f;

import java.awt.*;


public class Heart extends GameObject {

	public Heart(Vector2f origin, int size) {
		super(origin, size);
		type = type_pickupOnly;
		name = "Heart";
		HP = 100;
	}

	public void render(Graphics2D g) {

	}

//	public void use(Entity entity) {
//		gp.playSE(2);
//		gp.ui.addMessager("Life +" +value);
//		gp.player.setLife(gp.player.getLife() + value);
//	}
}
