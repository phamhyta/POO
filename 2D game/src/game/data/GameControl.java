package game.data;


import game.gameObject.monster.Enemy;
import game.gameObject.Material;
import game.gameObject.NPC;
import game.gameObject.Player;
import game.math.Vector2f;
import game.states.GameStateManager;
import game.tile.TileManager;
import game.util.Camera;
import game.util.KeyHandler;
import game.util.MouseHandler;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class GameControl {
    public Camera cam;
    public Player player;
    public GameStateManager gsm;
    private MapAsset[] mapAs;
    private int currentMap = 0;
    public static ArrayList<Material> materialGame;
    public Enemy[] enemy;
    public long[] deadStartTime;
    public NPC[] npc;
    public Vector2f[] origin;
    public TileManager tm;

    public GameControl(Player player, Camera cam, GameStateManager gsm) {
        this.player = player;
        this.cam = cam;
        this.gsm = gsm;
        this.mapAs = new MapAsset[5];
        materialGame = new ArrayList();
        this.enemy = new Enemy[20];
        this.origin = new Vector2f[20];
        this.deadStartTime = new long[20];

        for(int i = 0; i < this.deadStartTime.length; ++i) {
            this.deadStartTime[i] = 0L;
        }

        this.npc = new NPC[5];
        this.mapAs[0] = new Map01(this);
    }

    private void resetAsset() {
        materialGame.clear();

        int i;
        for(i = 0; i < this.enemy.length; ++i) {
            this.enemy[i] = null;
        }

        for(i = 0; i < this.npc.length; ++i) {
            this.npc[i] = null;
        }

    }

    public void update(double time) {
        int i;
        for(i = 0; i < materialGame.size(); ++i) {
            if (this.player.getBounds().collides(((Material)materialGame.get(i)).getBounds())) {
                if (((Material)materialGame.get(i)).type == 6) {
                    ((Material)materialGame.get(i)).use(this.player);
                    materialGame.remove(i);
                } else if (((Material)materialGame.get(i)).type != 8) {
                    this.player.setTargetMaterial((Material)materialGame.get(i));
                    materialGame.remove(i);
                }
            }
        }

        for(i = 0; i < this.enemy.length; ++i) {
            if (this.enemy[i] != null) {
                if (this.player.getHitBounds().collides(this.enemy[i].getBounds())) {
                    this.player.setTargetEnemy(this.enemy[i]);
                }

                if (this.enemy[i].getDeath()) {
                    this.player.setEXP(this.player.getEXP() + this.enemy[i].getEXP());
                    this.enemy[i].drop();
                    this.enemy[i] = null;
                    this.deadStartTime[i] = System.currentTimeMillis();
                } else {
                    this.enemy[i].update(this.player, time, this.origin[i]);
                }
            }

            if (this.enemy[i] == null && this.deadStartTime[i] != 0L && System.currentTimeMillis() - this.deadStartTime[i] > 5000L) {
                this.mapAs[this.currentMap].resetEnemy(i);
                this.deadStartTime[i] = 0L;
            }
        }

    }

    public void render(Graphics2D g) {
        this.tm.render(g);

        int i;
        for(i = 0; i < this.enemy.length; ++i) {
            if (this.enemy[i] != null && this.cam.getBounds().collides(this.enemy[i].getBounds())) {
                this.enemy[i].render(g);
            }
        }

        for(i = 0; i < materialGame.size(); ++i) {
            ((Material)materialGame.get(i)).render(g);
        }

    }

    public void input(MouseHandler mouse, KeyHandler key) {
        key.enter.tick();

        for(int i = 0; i < this.npc.length; ++i) {
            if (this.npc[i] != null && this.player.getBounds().collides(this.npc[i].getBounds()) && key.enter.clicked) {
            }
        }

    }
}