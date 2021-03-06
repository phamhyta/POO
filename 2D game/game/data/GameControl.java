package game.data;

import game.game_object.enemy.Enemy;
import game.game_object.npc.NPC;
import game.game_object.object.GameObject;
import game.game_object.Player;
import game.math.Vector2f;
import game.render.EntityRender;
import game.render.NPCRender;
import game.states.GameStateManager;
import game.tile.TileManager;
import game.ui.NpcUI;
import game.util.Camera;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class GameControl {
    public Camera cam;
    public Player player;
    public NpcUI pui;
    public GameStateManager gsm;
    private game.data.MapAsset mapAs;
    public static int currentMap = 0;
    public int defaultMap = 0;
    public boolean checkNextMap = false;
    public static ArrayList<GameObject> gameObject;
    public static Enemy[] enemy;
    private long[] deadStartTime;
    public NPC[] npc;
    public Vector2f[] origin;
    public TileManager tm;
    public EntityRender entityRender[];
    public NPCRender[] npcRender;

    public GameControl(Player player, Camera cam, GameStateManager gsm) {
        this.player = player;
        this.cam = cam;
        this.gsm = gsm;
        gameObject = new ArrayList();
        enemy = new Enemy[20];
        origin = new Vector2f[20];
        deadStartTime = new long[20];
        entityRender = new EntityRender[20];
        this.npc = new NPC[5];
        npcRender = new NPCRender[5];
        this.mapAs = new Map01(this);

    }

    public GameControl(Player player, Camera cam, GameStateManager gsm, boolean INSTRUCTION) {
        this.player = player;
        this.cam = cam;
        this.gsm = gsm;
        gameObject = new ArrayList();
        enemy = new Enemy[20];
        origin = new Vector2f[20];
        deadStartTime = new long[20];
        entityRender = new EntityRender[20];
        this.npc = new NPC[5];
        npcRender = new NPCRender[5];
        this.mapAs = new MapIntruction(this);
    }

    private void resetAsset() {
        gameObject.clear();
        for (int i = 0; i < this.enemy.length; ++i) {
            this.enemy[i] = null;
            this.entityRender[i] = null;
        }
        for (int i = 0; i < this.npc.length; ++i) {
            this.npc[i] = null;
        }
    }

    public static void setGameObject(GameObject go) {
        gameObject.add(go);
    }

    public void update(double time) {

        for (int i = 0; i < gameObject.size(); ++i) {
            if (this.player.getBounds().collides(gameObject.get(i).getBounds())) {
                if (gameObject.get(i).type == GameObject.type_consumable) {
                    gameObject.get(i).use(player);
                    gameObject.remove(i);
                } else if (gameObject.get(i).type == GameObject.type_nextMap) {
                    if (!checkNextMap) {
                        currentMap++;
                        checkNextMap = true;
                    }
                    System.out.println("CurrentMap: " + currentMap);
                    if (gsm.isStateActive(GameStateManager.PLAY)) {
                        player.resetPosition();
                    }
                } else {
                    if (gameObject.get(i).type != GameObject.type_Arrow) {
                        player.setTargetMaterial(gameObject.get(i));
                        gameObject.remove(i);
                    }
                }
            }
        }

        for (int i = 0; i < enemy.length; ++i) {
            if (this.enemy[i] != null) {
                if (player.getHitBounds().collides(enemy[i].getBounds())) {
                    player.setTargetEnemy(enemy[i]);
                }

                if (enemy[i].getDeath()) {
                    player.setEXP(player.getEXP() + enemy[i].getEXP());
                    player.setCoin(player.getCoin() + enemy[i].getCoin());
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
                deadStartTime[i] = 0;
            }
        }

        for (int i = 0; i < npc.length; i++) {
            if (npc[i] != null) {
                if (player.getHitBounds().collides(npc[i].getBounds())) {
                    if (npc[i].getName() == "Shop") {
                        System.out.println("Shop");
                        gsm.add(GameStateManager.DIALOGUES);
                        pui = new NpcUI(npc[i]);
                    }
                } else
                    gsm.pop(GameStateManager.DIALOGUES);
                if (npc[i].getName() == "Guide") {

                }
            }
        }

    }

    public void loadNewMap() {
        checkNextMap = false;
        if (currentMap == 0) {
            mapAs = new MapIntruction(this);
        } else if (currentMap == 1) {
            gsm.pop(GameStateManager.INSTRUCTION);
            gsm.add(GameStateManager.PLAY);
            // mapAs = new Map01(this);
        } else if (currentMap == 2) {
            mapAs = new Map02(this);
        } else {
            mapAs = new Map03(this);
        }
    }

    public void render(Graphics2D g) {
        if (currentMap != defaultMap) {
            resetAsset();
            loadNewMap();
            defaultMap = currentMap;
        }
        this.tm.render(g);
        for (int i = 0; i < enemy.length; i++) {
            if (enemy[i] != null && cam.getBounds().collides(enemy[i].getBounds())) {
                if (entityRender[i] != null) {
                    this.entityRender[i].render(g);
                }
            }
        }
        for (int i = 0; i < gameObject.size(); ++i) {
            gameObject.get(i).getObjectRender().render(g);
        }
        for (int i = 0; i < npcRender.length; i++) {
            if (npcRender[i] != null) {
                npcRender[i].render(g);
            }
        }
    }

}