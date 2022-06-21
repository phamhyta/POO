package game.gameObject.object;


<<<<<<< HEAD
<<<<<<<< HEAD:2D game/src/game/gameObject/object/OBJ_Heart.java
import game.gameObject.GameObject;
import game.graphics.SpriteSheet;
========
>>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6:2D game/src/game/gameObject/object/Heart.java
=======
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
import game.math.Vector2f;

import java.awt.*;


<<<<<<< HEAD
<<<<<<<< HEAD:2D game/src/game/gameObject/object/OBJ_Heart.java
public class OBJ_Heart extends GameObject {
========
public class Heart extends GameObject {
>>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6:2D game/src/game/gameObject/object/Heart.java
=======
public class Heart extends GameObject {
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6

	public Heart(Vector2f origin, int size) {
		super(origin, size);
		type = type_pickupOnly;
		name = "Heart";
		HP = 2;

	}

	public void render(Graphics2D g) {

	}

//	public void use(Entity entity) {
//		gp.playSE(2);
//		gp.ui.addMessager("Life +" +value);
//		gp.player.setLife(gp.player.getLife() + value);
//	}
}
