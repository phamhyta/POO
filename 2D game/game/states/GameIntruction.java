package game.states;

import game.GamePanel;

import game.data.GameControl;
import game.game_object.Player;
import game.game_object.object.item.Door;
import game.graphics.SpriteSheet;
import game.render.EntityRender;
import game.ui.NpcUI;
import game.ui.PlayerUI;
import game.util.Camera;
import game.util.KeyHandler;
import game.util.MouseHandler;
import game.math.Vector2f;

import java.awt.*;

public class GameIntruction extends GameState {

    public static Player player;
    private EntityRender playerRender;
    private Camera cam;
    private PlayerUI pui;
    private GameControl gc;
    private NpcUI npcui;
    private int mission[];
    private boolean missionDone = true;

    public GameIntruction(GameStateManager gsm, Camera cam) {
        super(gsm);
        this.mission = new int[10];
        GameStateManager.map = new Vector2f(0, 0);
        Vector2f.setWorldVar(GameStateManager.map.x, GameStateManager.map.y);
        this.cam = cam;
        player = new Player(new Vector2f(0 + (GamePanel.width / 2), 0 + (GamePanel.height / 2)), 64);
        playerRender = new EntityRender(player, new SpriteSheet("res/entity/linkFormatted_new.png", 32, 32));
        cam.target(player);
        gc = new GameControl(player, cam, gsm, true);
        pui = new PlayerUI(player);
        npcui = new NpcUI(gc.npc[0]);

        setUp();
    }

    public void update(double time) {
        Vector2f.setWorldVar(GameStateManager.map.x, GameStateManager.map.y);
        player.setHealth(player.getMaxHealth());
        player.setCurrentMana(player.getMaxMana());
        playerRender.update();
        player.update(time);
        gc.update(time);
        pui.update(time);
        cam.update();

        mission1();
        mission2();
        mission3();
        mission4();
    }

    public void setUp() {
        for (int i = 1; i <= 9; i++) {
            this.mission[i] = 0;
        }
    }

    public void input(MouseHandler mouse, KeyHandler key) {
        player.input(mouse, key);
        cam.input(mouse, key);
        if (this.missionDone) {
            gc.npc[0].input(mouse, key);
        }

    }

    public void mission1() {
        if (gc.npc[0].getCurrentConversation() == 1 && this.mission[1] == 0) {
            this.missionDone = false;
            this.mission[1] = 1;
        }
        if (gc.npc[0].getCurrentConversation() == 1 && this.mission[1] == 1) {
            gc.npc[0].setTalk(false);
        }
        if (player.getHitBounds().collides(gc.npc[2].getBounds()) && mission[1] == 1) {
            this.mission[1] = 2;
            this.mission[2] = 0;
            gc.npc[0].setTalk(true);
            this.missionDone = true;
        }
    }

    public void mission2() {
        if (mission[1] == 2) {
            if (mission[2] == 0) {
                if (gc.npc[0].getCurrentConversation() == 4) {
                    this.missionDone = false;
                    gc.npc[0].setTalk(false);
                    mission[2] = 1;
                    Vector2f pos = new Vector2f(1000, 600);
                    gc.origin[1] = pos;
                    GameControl.enemy[1].setPos(pos);
                }
            }
            if (mission[2] == 1) {
                if (GameControl.enemy[1] == null) {
                    mission[2] = 2;
                    gc.npc[0].setTalk(true);
                    this.missionDone = true;
                }
            }
        }
    }

    public void mission3() {
        if (mission[2] == 2) {
            if (mission[3] == 0) {
                if (gc.npc[0].getCurrentConversation() == 6) {
                    this.missionDone = false;
                    gc.npc[0].setTalk(false);
                    mission[3] = 1;
                    Vector2f pos = new Vector2f(1000, 600);
                    gc.origin[3] = pos;
                    GameControl.enemy[3].setPos(pos);
                }
            }
            if (mission[3] == 1) {
                if (GameControl.enemy[3] == null) {
                    mission[3] = 2;
                    gc.npc[0].setTalk(true);
                    this.missionDone = true;
                }
            }
        }
    }

    public void mission4() {
        if (mission[3] == 2) {
            if (mission[4] == 0) {
                if (gc.npc[0].getCurrentConversation() == 8) {
                    this.missionDone = false;
                    gc.npc[0].setTalk(false);
                    mission[4] = 1;
                }
            }
            if (mission[4] == 1) {
                GameControl.gameObject.add(new Door(new Vector2f(1000, 600), 48));
            }
        }
    }

    public void render(Graphics2D g) {

        gc.render(g);
        playerRender.render(g);
        pui.render(g);
        if (gc.npc[0] != null && gc.npc[0].isTalking()) {
            npcui.render(g);
        }

    }

}
