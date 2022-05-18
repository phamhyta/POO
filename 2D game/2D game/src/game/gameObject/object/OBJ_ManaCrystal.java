package game.gameObject.object;

import game.gameObject.Material;
import game.gameObject.Player;
import game.graphics.SpriteSheet;
import game.math.Vector2f;

import java.awt.*;


public class OBJ_ManaCrystal extends Material {

	public OBJ_ManaCrystal(Vector2f origin, int size) {
		super(origin, size);

		type = type_consumable;
		name = "Mana Crystal";
		MP =10;
		spriteSheet = new SpriteSheet("ui/items.png");
		image =  spriteSheet.getSubimage(32,0,32,32);
	}

	public void use(Player player) {
		if(player.getMana() + this.MP < player.getMaxMana()) {
			player.setCurrentMana(player.getMana() + this.MP);
		}
		else{
			player.setCurrentMana(player.getMaxMana());
		}
	}

	public void render(Graphics2D g){
	g.drawImage(image,(int)pos.getWorldVar().x,(int)pos.getWorldVar().y,size,size, null);
	}
}
