package game.states;

import game.GamePanel;

import game.data.GameControl;
import game.gameObject.Player;
import game.gameObject.object.OBJ_Door;
import game.graphics.SpriteSheet;
import game.tile.TileManager;
import game.ui.PlayerUI;
import game.util.Camera;
import game.util.KeyHandler;
import game.util.MouseHandler;
import game.math.Vector2f;


import java.awt.*;


public class PlayState extends GameState {
    private TileManager tm;
    private Player player;

    public static Vector2f map;
    private Camera cam;
    private PlayerUI pui;
    private GameControl gc;

    private OBJ_Door obj_door;

    public PlayState(GameStateManager gsm, Camera cam) {
        super(gsm);
        map = new Vector2f(0,0);
        Vector2f.setWorldVar(map.x,map.y);
        this.cam = cam;
        player = new Player(cam, new SpriteSheet("res/entity/linkFormatted.png", 32, 32), new Vector2f(0 + (GamePanel.width / 2) - 32, 0 + (GamePanel.height / 2) - 32), 64);
        gc = new GameControl(player, cam, gsm);

        cam.target(player);
        pui = new PlayerUI(player);
    }


    public void update(double time) {
        Vector2f.setWorldVar(map.x,map.y);

        if(!gsm.isStateActive(GameStateManager.PAUSE) && !gsm.isStateActive(GameStateManager.GAMEOVER) ){
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
        pui.input(mouse, key);
    }
    public void render(Graphics2D g) {
        gc.render(g);
        player.render(g);

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