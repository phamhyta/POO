package game.states;

import game.GamePanel;

import game.data.GameControl;
import game.game_object.Player;
import game.game_object.object.item.Door;
import game.graphics.SpriteSheet;
import game.render.EntityRender;
import game.ui.PlayerUI;
import game.util.Camera;
import game.util.KeyHandler;
import game.util.MouseHandler;
import game.math.Vector2f;

import java.awt.*;

public class GameIntruction1 extends GameState {

    public static Player player;
    private EntityRender playerRender;
    public static Vector2f map;
    private Camera cam;
    private PlayerUI pui;
    private GameControl gc;

    public GameIntruction1(GameStateManager gsm, Camera cam) {
        super(gsm);
        map = new Vector2f(0, 0);
        Vector2f.setWorldVar(map.x, map.y);
        this.cam = cam;
        player = new Player(new Vector2f(0 + (GamePanel.width / 2) + 100, 0 + (GamePanel.height / 2) + 150), 64);
        playerRender = new EntityRender(player, new SpriteSheet("res/entity/linkFormatted_new.png", 32, 32));
        gc = new GameControl(player, cam, gsm,true );
        pui = new PlayerUI(player);
    }

    public void update(double time) {
        Vector2f.setWorldVar(map.x, map.y);
        if (!gsm.isStateActive(GameStateManager.PAUSE) && !gsm.isStateActive(GameStateManager.GAMEOVER)
                && !gsm.isStateActive(GameStateManager.SHOP) && !gsm.isStateActive(GameStateManager.MENU) ) {
            playerRender.update();
            player.update(time);
            gc.update(time);
            pui.update(time);
            cam.update();
        }
        if(gc.enemy[1]==null){
            gc.gameObject.add(new Door(new Vector2f(1000,600),48));
        }
    }

    public void input(MouseHandler mouse, KeyHandler key) {
        player.input(mouse, key);
    }

    public void render(Graphics2D g) {
        gc.render(g);
        playerRender.render(g);
        pui.render(g);
    }



    public Player getPlayer() {
        return this.player;
    }
}
