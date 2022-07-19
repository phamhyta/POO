package game.states;

import game.GamePanel;

import game.data.GameControl;
import game.game_object.Player;
import game.graphics.Animation;
import game.graphics.SpriteSheet;
import game.render.EntityRender;
import game.ui.PlayerUI;
import game.util.Camera;
import game.util.KeyHandler;
import game.util.MouseHandler;
import game.math.Vector2f;

import java.awt.*;

public class PlayState extends GameState {

    public static Player player;
    private EntityRender playerRender;
    private Camera cam;
    private PlayerUI pui;
    private GameControl gc;
    private boolean music;

    public PlayState(GameStateManager gsm, Camera cam) {
        super(gsm);
        GameStateManager.map = new Vector2f(0, 0);
        Vector2f.setWorldVar(GameStateManager.map.x, GameStateManager.map.y);
        this.music = true;
        this.cam = cam;
        player = new Player(new Vector2f(0 + (GamePanel.width / 2) + 100, 0 + (GamePanel.height / 2) + 150), 64);
        playerRender = new EntityRender(player, new SpriteSheet("res/entity/linkFormatted_new.png", 32, 32));
        gc = new GameControl(player, cam, gsm);
        gc.currentMap = 1;
        gc.defaultMap = 1;
        cam.target(player);
        pui = new PlayerUI(player);
        gsm.sound.playLoopMusic(0);
    }

    public void update(double time) {
        Vector2f.setWorldVar(GameStateManager.map.x, GameStateManager.map.y);
        if (!gsm.isStateActive(GameStateManager.PAUSE) && !gsm.isStateActive(GameStateManager.GAMEOVER)
                && !gsm.isStateActive(GameStateManager.SHOP) && !gsm.isStateActive(GameStateManager.MENU) ) {
            playerRender.update();
            player.update(time);
            gc.update(time);
            pui.update(time);
            cam.update();
        }
    }

    public void input(MouseHandler mouse, KeyHandler key) {
        key.escape.tick();
        player.input(mouse, key);
        key.menu.tick();
        cam.input(mouse, key);
        if (key.escape.clicked) {
            if (gsm.isStateActive(GameStateManager.PAUSE)) {
                gsm.pop(GameStateManager.PAUSE);
            } else {
                gsm.add(GameStateManager.PAUSE);
            }

        }
        key.shop.tick();
        if (key.shop.clicked) {
            if (gsm.isStateActive(GameStateManager.SHOP)) {
                gsm.pop(GameStateManager.DIALOGUES);
            } else {
                if (gsm.isStateActive(GameStateManager.DIALOGUES)) {
                    gsm.add(GameStateManager.SHOP);
                    gsm.pop(GameStateManager.DIALOGUES);
                }
            }
        }
        if (key.menu.clicked) {
            if (gsm.isStateActive(GameStateManager.MENU)) {
                gsm.pop(GameStateManager.MENU);
            } else {
                gsm.add(GameStateManager.MENU);
            }
        }
        pui.input(mouse, key);
        if (this.player.getHealth() <= 0) {
            gsm.add(GameStateManager.GAMEOVER);
        }
        
    }

    public void render(Graphics2D g) {
        gc.render(g);
        playerRender.render(g);
        String fps = GamePanel.oldFrameCount + " FPS";
        SpriteSheet.drawArray(g, fps, new Vector2f(GamePanel.width - fps.length() * 32, 32), 32, 24);
        String tps = GamePanel.oldTickCount + " TPS";
        SpriteSheet.drawArray(g, tps, new Vector2f(GamePanel.width - fps.length() * 32, 64), 32, 24);
        String coinInterface = "Coin:" + player.getCoin();
        SpriteSheet.drawArray(g, coinInterface, new Vector2f(GamePanel.width - coinInterface.length() * 32, 96), 32,
                24);
        pui.render(g);
    }

    public void chageMusic() {
        if (this.music == true) {
            this.music = false;
            this.gsm.sound.stopMusic();
        } else {
            this.music = true;
            this.gsm.sound.playLoopMusic(0);
            ;
        }
    }

    public Player getPlayer() {
        return this.player;
    }
}
