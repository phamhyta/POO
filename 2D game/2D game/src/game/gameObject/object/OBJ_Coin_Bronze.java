package game.gameObject.object;

import game.gameObject.Material;
import game.gameObject.Player;
import game.graphics.SpriteSheet;
import game.math.Vector2f;

import java.awt.*;


public class OBJ_Coin_Bronze extends Material {

	public OBJ_Coin_Bronze(Vector2f origin, int size, int value) {
		super(origin, size);
		this.coin = value;
		type= type_consumable;
		name = "Bronze Coin";
		spriteSheet = new SpriteSheet("ui/items.png");
		image =  spriteSheet.getSubimage(3*32,5*32,32,32);
	}

	public void use(Player player) {
		player.setCoin( player.getCoin() + this.coin);
	}

	@Override
	public void render(Graphics2D g) {
		g.drawImage(image,(int)pos.getWorldVar().x,(int)pos.getWorldVar().y,size,size, null);
	}
}
