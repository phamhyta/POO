package game.data;

<<<<<<< HEAD
<<<<<<< HEAD
import game.gameObject.GameObject;
import game.gameObject.monster.Enemy;
=======
import game.gameObject.object.GameObject;
import game.gameObject.enemy.Enemy;
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
=======
import game.gameObject.object.GameObject;
import game.gameObject.enemy.Enemy;
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
import game.gameObject.NPC;
import game.gameObject.Player;
import game.math.Vector2f;
import game.render.EntityRender;
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
<<<<<<< HEAD
<<<<<<< HEAD
    private MapAsset[] mapAs;
    private int currentMap = 0;
    private static ArrayList<GameObject> gameObject;
    public Enemy[] enemy;
=======
=======
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
    private MapAsset mapAs;
    public static int currentMap = 0;
    public static ArrayList<GameObject> gameObject;
    public static Enemy[] enemy;
<<<<<<< HEAD
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
=======
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
    public long[] deadStartTime;
    public NPC[] npc;
    public Vector2f[] origin;
    public TileManager tm;
    public EntityRender entityRender[];

    public GameControl(Player player, Camera cam, GameStateManager gsm) {
        this.player = player;
        this.cam = cam;
        this.gsm = gsm;
<<<<<<< HEAD
<<<<<<< HEAD
        mapAs = new MapAsset[5];
=======
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
=======
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
        gameObject = new ArrayList();
        enemy = new Enemy[20];
        origin = new Vector2f[20];
        deadStartTime = new long[20];
        entityRender = new EntityRender[20];

<<<<<<< HEAD
<<<<<<< HEAD
        for(int i = 0; i < this.deadStartTime.length; ++i) {
            this.deadStartTime[i] = 0L;
        }
        this.npc = new NPC[5];

        this.mapAs[0] = new Map01(this);
=======
        this.npc = new NPC[5];
        mapAs = new Map01(this);
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
=======
        this.npc = new NPC[5];
        mapAs = new Map01(this);
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
    }

    private void resetAsset() {
        gameObject.clear();
<<<<<<< HEAD
<<<<<<< HEAD
        for(int i = 0; i < this.enemy.length; ++i) {
            this.enemy[i] = null;
            this.entityRender[i]=null;
        }

        for(int i = 0; i < this.npc.length; ++i) {
=======
=======
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
        for (int i = 0; i < this.enemy.length; ++i) {
            this.enemy[i] = null;
            this.entityRender[i] = null;
        }
        for (int i = 0; i < this.npc.length; ++i) {
<<<<<<< HEAD
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
=======
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
            this.npc[i] = null;
        }

    }

    public void update(double time) {

<<<<<<< HEAD
<<<<<<< HEAD
        for(int i = 0; i < gameObject.size(); ++i) {
            if (this.player.getBounds().collides(gameObject.get(i).getBounds())) {
                if (gameObject.get(i).type == 6) {
                    gameObject.get(i).use(player);
                    gameObject.remove(i);
                } else if (gameObject.get(i).type != 8) {
=======
=======
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
        for (int i = 0; i < gameObject.size(); ++i) {
            if (this.player.getBounds().collides(gameObject.get(i).getBounds())) {
                if (gameObject.get(i).type == GameObject.type_consumable) {
                    gameObject.get(i).use(player);
                    gameObject.remove(i);
                } else if (gameObject.get(i).type != GameObject.type_nextMap) {
<<<<<<< HEAD
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
=======
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
                    player.setTargetMaterial(gameObject.get(i));
                    gameObject.remove(i);
                }
            }
        }

<<<<<<< HEAD
<<<<<<< HEAD
        for(int i = 0; i < enemy.length; ++i) {
            if (this.enemy[i] != null) {
=======
        for (int i = 0; i < enemy.length; ++i) {
            if (this.enemy[i] != null) {

>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
=======
        for (int i = 0; i < enemy.length; ++i) {
            if (this.enemy[i] != null) {

>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
                if (player.getHitBounds().collides(enemy[i].getBounds())) {
                    player.setTargetEnemy(enemy[i]);
                }

                if (enemy[i].getDeath()) {
<<<<<<< HEAD
<<<<<<< HEAD
                    player.setEXP(this.player.getEXP() + enemy[i].getEXP());
                    enemy[i].drop();
                    entityRender[i]= null;
                    enemy[i] = null;
                    deadStartTime[i] = System.currentTimeMillis();
                } else {
                    if(entityRender[i] != null) entityRender[i].update();
                    enemy[i].update(player, time, origin[i]);
                }
            }

            if (enemy[i] == null && this.deadStartTime[i] != 0L && System.currentTimeMillis() - deadStartTime[i] > 5000L) {
                mapAs[currentMap].resetEnemy(i);
=======
=======
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
                    player.setEXP(player.getEXP() + enemy[i].getEXP());
                    enemy[i].drop();
                    entityRender[i] = null;
                    enemy[i] = null;
                    deadStartTime[i] = System.currentTimeMillis();
                } else {
                    if (entityRender[i] != null)
                        entityRender[i].update();
                        enemy[i].update(player, time, origin[i]);
                }
            }

            if (enemy[i] == null && this.deadStartTime[i] != 0L
                    && System.currentTimeMillis() - deadStartTime[i] > 5000L) {
                mapAs.resetEnemy(i);
<<<<<<< HEAD
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
=======
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
                deadStartTime[i] = 0L;
            }
        }

<<<<<<< HEAD
<<<<<<< HEAD

=======
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
=======
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
    }

    public void render(Graphics2D g) {
        this.tm.render(g);
        for(int i = 0; i < enemy.length; i++) {
            if (enemy[i] != null && cam.getBounds().collides(enemy[i].getBounds())) {
                if(entityRender[i] != null) {
                    this.entityRender[i].render(g);
                }
            }
        }
<<<<<<< HEAD
<<<<<<< HEAD

        for(int i = 0; i < gameObject.size(); ++i) {
            gameObject.get(i).render(g);
        }

    }

    public void input(MouseHandler mouse, KeyHandler key) {
=======
=======
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
        for(int i = 0; i < gameObject.size(); ++i) {
            gameObject.get(i).getObjectRender().render(g);
        }
    }

    public  void input(MouseHandler mouse, KeyHandler key) {
<<<<<<< HEAD
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
=======
>>>>>>> 4d72d22ccbea68d402644b700aed4dfd928807d6
        key.enter.tick();

        for(int i = 0; i < this.npc.length; ++i) {
            if (npc[i] != null && player.getBounds().collides(npc[i].getBounds()) && key.enter.clicked) {
            }
        }
    }

    public static void setGameObject(GameObject go) {
        gameObject.add(go);
    }
}