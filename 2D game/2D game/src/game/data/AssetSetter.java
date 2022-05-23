package game.data;
import game.gameObject.Enemy;
import game.gameObject.Material;
import game.gameObject.Player;
import game.gameObject.monster.TinyBox;
import game.gameObject.monster.TinyMon;
import game.gameObject.object.OBJ_Door;
import game.gameObject.object.OBJ_Potion_Red;
import game.graphics.SpriteSheet;
import game.util.Camera;
import game.math.Vector2f;

import java.awt.*;
import java.util.ArrayList;


public class AssetSetter {
    private Camera cam;
    private Player player;

    public static ArrayList<Material> materialGame;

    private Enemy[] enemy;
    private long[] deadStartTime;
    private Vector2f[] origin;


    public AssetSetter(Player player,Camera cam){
        this.player = player;
        this.cam= cam;

        materialGame = new ArrayList<>();
        enemy = new Enemy[20];
        origin = new Vector2f[20];

        deadStartTime = new long[50];
        for(int i=0; i< deadStartTime.length; i++){
            deadStartTime[i]=0;
        }
        setMonsterPosition();
        setMaterialPosition();

    }

    private void setMonsterPosition() {
        int i =0;
        SpriteSheet minimonsterSheet = new SpriteSheet("entity/minimonsters.png",16,16);
        origin[i] = new Vector2f(500, 500);
        enemy[i] = new TinyBox(cam,new SpriteSheet(minimonsterSheet.getSprite(0,0,128,32),16,16),new Vector2f(origin[i]), 64);
        i++;
        origin[i] = new Vector2f(600, 600);
        enemy[i] = new TinyBox(cam,new SpriteSheet(minimonsterSheet.getSprite(0,1,128,32),16,16),new Vector2f(origin[i]), 64);
        i++;
        origin[i] = new Vector2f(550, 550);
        enemy[i] = new TinyBox(cam,new SpriteSheet(minimonsterSheet.getSprite(0,2,128,32),16,16),new Vector2f(origin[i]), 64);
        i++;
        origin[i] = new Vector2f(570, 590);
        enemy[i] = new TinyBox(cam,new SpriteSheet(minimonsterSheet.getSprite(0,3,128,32),16,16),new Vector2f(origin[i]), 64);
        i++;
        origin[i] = new Vector2f(1070, 1070);
        enemy[i]= new TinyMon(cam,new SpriteSheet("entity/littlegirl.png",48,48),new Vector2f(origin[i]), 64);
        i++;
        origin[i] = new Vector2f(1000, 1000);
        enemy[i]= new TinyMon(cam,new SpriteSheet("entity/littlegirl.png",48,48),new Vector2f(origin[i]), 64);
        i++;
        origin[i] = new Vector2f(1500, 1500);
        enemy[i]= new TinyMon(cam,new SpriteSheet("entity/littlegirl.png",48,48),new Vector2f(origin[i]), 64);
        i++;
        origin[i] = new Vector2f(700, 1000);
        enemy[i]= new TinyMon(cam,new SpriteSheet("entity/littlegirl.png",48,48),new Vector2f(origin[i]), 64);
    }

    private void setMaterialPosition() {
        materialGame.add(new OBJ_Potion_Red(new Vector2f(500,500), 32));
    }

    private void resetAsset(){
        materialGame.clear();
        for(int i=0; i< enemy.length; i++){
            enemy[i] =null;
        }
    }

    private void resetEnemy(int i){
        SpriteSheet minimonsterSheet = new SpriteSheet("entity/minimonsters.png",16,16);
        if(i<2){
            enemy[i] = new TinyBox(cam,new SpriteSheet(minimonsterSheet.getSprite(0,0,128,32),16,16),new Vector2f(origin[i]), 64);
        }
        else if(i <4){
            enemy[i] = new TinyBox(cam,new SpriteSheet(minimonsterSheet.getSprite(0,1,128,32),16,16),new Vector2f(origin[i]), 64);
        }
        else{
            enemy[i]= new TinyMon(cam,new SpriteSheet("entity/littlegirl.png",48,48),new Vector2f(origin[i]), 64);
        }
    }

    public void update(double time){

        for(int i=0; i< materialGame.size(); i++){
            if(player.getBounds().collides(materialGame.get(i).getBounds())){

                if(materialGame.get(i).type == Material.type_consumable){
                    materialGame.get(i).use(player);
                    materialGame.remove(i);
                    //player use it
                }else if(materialGame.get(i).type == Material.type_nextMap){
                    // nextMap
                }
                else {
                    //add to inventory
                    player.setTargetMaterial(materialGame.get(i));
                    materialGame.remove(i);
                }
            }
        }

        for(int i =0 ; i< enemy.length; i++){
            if(enemy[i] != null){
                if(player.getHitBounds().collides(enemy[i].getBounds())) {
                    player.setTargetEnemy(enemy[i]);
                }
                if(enemy[i].getDeath()){
                    player.setEXP(player.getEXP()+enemy[i].getEXP());
                    enemy[i].drop();
                    enemy[i]= null;
                    deadStartTime[i] = System.currentTimeMillis();
                }
                else{
                    enemy[i].update(player,time,origin[i]);
                }
            }
            if(enemy[i]== null && deadStartTime[i] !=0){
                if(System.currentTimeMillis() - deadStartTime[i] > 5000){
                    resetEnemy(i);
                    deadStartTime[i]=0;
                }
            }
        }
    }

    public void render(Graphics2D g){

        for(int i=0; i< enemy.length; i++){
            if(enemy[i] != null){
                if(cam.getBounds().collides(enemy[i].getBounds())) {
                    enemy[i].render(g);
                }
            }
        }
        for(int i=0; i< materialGame.size(); i++){
            materialGame.get(i).render(g);
        }
    }


}
