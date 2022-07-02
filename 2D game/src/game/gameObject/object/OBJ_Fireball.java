//package game.gameObject.object;
//
//import java.awt.image.BufferedImage;
//
//import entity.Entity;
//import entity.Projectile;
//import main.GamePanel;
//
//public class OBJ_Fireball extends Projectile {
//
//	GamePanel gp;
//
//	public OBJ_Fireball(GamePanel gp) {
//		super(gp);
//		this.gp= gp;
//
//		name = "Fireball";
//		setSpeed(8);
//		setMaxLife(80);
//		setLife(getMaxLife());
//		setAttack(2);
//		useCost=1;
//		setAlive(false);
//		getImage();
//	}
//
//	public void getImage() {
//		up1 = setup("/projectile/fireball_up_1",gp.tileSize,gp.tileSize);
//		up2 = setup("/projectile/fireball_up_2",gp.tileSize,gp.tileSize);
//		down1 = setup("/projectile/fireball_down_1",gp.tileSize,gp.tileSize);
//		down2 = setup("/projectile/fireball_down_2",gp.tileSize,gp.tileSize);
//		left1 = setup("/projectile/fireball_left_1",gp.tileSize,gp.tileSize);
//		left2 = setup("/projectile/fireball_left_2",gp.tileSize,gp.tileSize);
//		right1 = setup("/projectile/fireball_right_1",gp.tileSize,gp.tileSize);
//		right2 = setup("/projectile/fireball_right_2",gp.tileSize,gp.tileSize);
//	}
//	public boolean haveResource(Entity user) {
//		boolean haveResource = false;
//		if(user.getMana() >= useCost) {
//			haveResource = true;
//		}
//		return haveResource;
//	}
//	public void subtractResource(Entity user) {
//		user.setMana(user.getMana() - useCost);
//	}
//}
