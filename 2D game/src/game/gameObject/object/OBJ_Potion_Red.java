package game.gameObject.object;

import game.gameObject.GameObject;
import game.gameObject.Player;
import game.graphics.SpriteSheet;
import game.math.Vector2f;

import java.awt.Graphics2D;


public class OBJ_Potion_Red extends GameObject {

	public OBJ_Potion_Red(Vector2f origin, int size) {
		super(origin, size);
		type= type_consumable;
		name = "Red Potion";
		HP =50;
		spriteSheet = new SpriteSheet("res/ui/items.png");
		image =  spriteSheet.getSubimage(0,288,32,32);

	}

	public void use(Player player) {
		if(player.getHealth() + this.HP < player.getMaxHealth()) {
			player.setCurrentHealth(player.getHealth() + this.HP);
		}
		else{
			player.setCurrentHealth(player.getMaxHealth());
		}
	}

	public void render(Graphics2D g){
		g.drawImage(image,(int)pos.getWorldVar().x,(int)pos.getWorldVar().y,size,size, null);
	}
}
