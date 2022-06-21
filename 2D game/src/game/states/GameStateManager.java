package game.states;

import game.GamePanel;
import game.graphics.Font;

import game.graphics.Fontf;
import game.graphics.SpriteSheet;
import game.math.BoundingBox;
import game.util.Camera;
import game.util.KeyHandler;
import game.util.MouseHandler;
import game.math.Vector2f;


import java.awt.*;

public class GameStateManager {

    private GameState states[];
    public static Vector2f map;


    public static final int TITLE = 0;
    public static final int PLAY = 1;
    public static final int PAUSE = 2;
    public static final int GAMEOVER = 3;
    public static final int SHOP = 4;
    public static final int DIALOGUES = 5;

    public static Camera cam;
    public Graphics2D g;

    public static Font font;
    public static Fontf fontf;

    public GameStateManager(Graphics2D g){
        this.g=g;
        map = new Vector2f( GamePanel.width, GamePanel.height);
        Vector2f.setWorldVar(map.x, map.y);
        states= new GameState[10];
        font = new Font("res/font/font.png",10,10);
        fontf = new Fontf();
        fontf.loadFont("res/font/Stackedpixel.ttf", "MeatMadness");
        fontf.loadFont("res/font/MotionPersonalUseBold-2O0od.ttf", "Motion");
        fontf.loadFont("res/font/x12y16pxMaruMonica.ttf", "MaruMonica");

        SpriteSheet.currentFont = font;
        cam = new Camera(new BoundingBox(new Vector2f(-64, -64), GamePanel.width + 128, GamePanel.height + 128));
        states[TITLE]= new TitleState(this);

    }
    public boolean isStateActive(int state) {
        return states[state] != null;
    }

    public GameState getState(int state) {
        return states[state];
    }

    public void pop(int state) {
        states[state] = null;
    }
    public void add(int state) {
        if (states[state] != null)
            return;

        if (state == PLAY) {
            cam = new Camera(new BoundingBox(new Vector2f(0, 0), GamePanel.width + 64, GamePanel.height + 64));
            states[PLAY] = new PlayState(this,cam);
        }
        else if (state == TITLE) {
            states[TITLE] = new MenuState(this);
        }
        else if (state == PAUSE) {
            states[PAUSE] = new PauseState(this);
        }
        else if (state == GAMEOVER) {
            states[GAMEOVER] = new GameOverState(this);
        }
        else if (state == SHOP) {
            states[SHOP] = new ShopState(this);
        }
        else if (state == DIALOGUES) {
            states[DIALOGUES] = new DialoguesState(this);
        }
//        else if (state == EDIT) {
//            if(states[PLAY] != null) {
//                states[EDIT] = new EditState(this, cam);
//            }
        }

    public void addAndpop(int state) {
        addAndpop(state, 0);
    }

    public void addAndpop(int state, int remove) {
        pop(state);
        add(state);
    }

    public void update(double time) {
        for (int i = 0; i < states.length; i++) {
            if (states[i] != null) {
                states[i].update(time);
            }
        }
    }
    public void input(MouseHandler mouse, KeyHandler key){
        for(int i=0; i< states.length;i++) {
            if (states[i] != null) {
                states[i].input(mouse, key);
            }
        }
    }

    public void render(Graphics2D g){
        for(int i=0; i< states.length;i++){
            if (states[i] != null) {
                states[i].render(g);
            }
        }
    }

}
