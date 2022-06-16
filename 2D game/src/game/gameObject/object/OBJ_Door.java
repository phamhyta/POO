package game.gameObject.object;

import game.gameObject.GameObject;
import game.graphics.SpriteSheet;
import game.math.Vector2f;

import java.awt.Graphics2D;

public class OBJ_Door extends GameObject {


		public OBJ_Door(Vector2f origin, int size) {
			super(origin, size);

//			name = "Door";
			type = type_player;
			spriteSheet = new SpriteSheet("res/ui/items.png");
			image =  spriteSheet.getSubimage(192,64,32,32);

		}
	public void render(Graphics2D g){
		g.drawImage(image,(int)pos.getWorldVar().x,(int)pos.getWorldVar().y,size,size, null);
		}
	}
