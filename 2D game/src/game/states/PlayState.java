package game.states;

import game.GamePanel;

import game.data.GameControl;
import game.gameObject.Player;
import game.graphics.SpriteSheet;
import game.render.EntityRender;
import game.ui.PlayerUI;
import game.util.Camera;
import game.util.KeyHandler;
import game.util.MouseHandler;
import game.math.Vector2f;
import game.util.Sound;

import java.awt.*;


public class PlayState extends GameState {

    private Player player;
    private EntityRender playerRender;

    public static Vector2f map;
    private Camera cam;
    private PlayerUI pui;
    private GameControl gc;


    public PlayState(GameStateManager gsm, Camera cam) {
        super(gsm);
        map = new Vector2f(0,0);
        Vector2f.setWorldVar(map.x,map.y);
        this.cam = cam;
        player = new Player(new Vector2f(0 + (GamePanel.width / 2) +100, 0 + (GamePanel.height / 2) +100), 64);
        playerRender = new EntityRender(cam,player,new SpriteSheet("res/entity/linkFormatted_new.png", 32, 32) );
        gc = new GameControl(player, cam, gsm);
        cam.target(player);
        pui = new PlayerUI(player);
        gsm.sound.playLoopMusic(0);
    }


    public void update(double time) {
        Vector2f.setWorldVar(map.x,map.y);
        if(!gsm.isStateActive(GameStateManager.PAUSE) && !gsm.isStateActive(GameStateManager.GAMEOVER) && !gsm.isStateActive(GameStateManager.SHOP) ){
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
        cam.input(mouse,key);
        if(key.escape.clicked){
            if(gsm.isStateActive(GameStateManager.PAUSE)){
                gsm.pop(GameStateManager.PAUSE);
            }else{
                gsm.add(GameStateManager.PAUSE);
            }

        }
        key.shop.tick();
        if(key.shop.clicked){
            if(gsm.isStateActive(GameStateManager.SHOP)){
                gsm.pop(GameStateManager.SHOP);
            }else{
                gsm.add(GameStateManager.SHOP);
            }

        }
        pui.input(mouse, key);
    }
    public void render(Graphics2D g) {
        gc.render(g);
        playerRender.render(g);

        String fps = GamePanel.oldFrameCount + " FPS";
        SpriteSheet.drawArray(g,fps, new Vector2f(GamePanel.width- fps.length()*32,32) , 32,24);
        String tps = GamePanel.oldTickCount + " TPS";
        SpriteSheet.drawArray(g,tps, new Vector2f(GamePanel.width- fps.length()*32,64) , 32,24);
        String coinInterface = "Coin:"+player.getCoin();
        SpriteSheet.drawArray(g,coinInterface, new Vector2f(GamePanel.width- coinInterface.length()*32,96) , 32,24);

        cam.render(g);
        pui.render(g);
    }
}
