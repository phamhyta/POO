package game.data;

import game.graphics.SpriteSheet;
import game.math.Vector2f;
import game.tile.TileManager;


public class MapIntruction extends MapAsset {

    public MapIntruction(GameControl gc){
        super(gc);
        gc.tm = new TileManager("res/tile/intro.xml", gc.cam);
       
    }
    @Override
    protected void setMonsterPosition() {
        int i = 1;
        SpriteSheet minimonsterSheet = new SpriteSheet("res/entity/minimonsters.png", 16, 16);
        gc.origin[i] = new Vector2f(1000, 1000);
        setTinyBox( i, gc.origin[i], new SpriteSheet(minimonsterSheet.getSprite(0, 0, 128, 32), 16, 16), 48);
        
        i = 0;
        minimonsterSheet = new SpriteSheet("res/entity/monsters.png", 24, 24);
        gc.origin[i] = new Vector2f(150,450);
        setNPC(i,gc.origin[i],new SpriteSheet(minimonsterSheet.getSprite(0,10,128,16),16,16),48,"Guide");
        gc.npc[0].setTalk(0, "Old man: Ai do! Lai day cho ta nhin ro mat");
        gc.npc[0].setTalk(1, "Old man: Hoa ra la dung si\nHom nay dung si den day co viec gi vay?");
        gc.npc[0].setTalk(2,"Dung si: Toi muon tru hai cho nhan gian\nNen can mot vai mon vu khi\nLao co the giup toi chuyen do khong?");
        gc.npc[0].setTalk(3,"Old man: Toi co 1 thanh kiem co the giup duoc\nchuyen do\nva co the su dung SPACE de chem\nDung si co the thu kiem voi thu cung cua toi!");
        gc.npc[0].setTalk(4,"Dung si: Qua la mot thanh kiem tot\nNhung ta nghi nhu vay la chua du\nLao con mon gi co the tan cong tu xa khong?");
        gc.npc[0].setTalk(5,"Old man: Ta con co mot cay cung nay giao cho\ndung si\nAnh co the bam K co the tan quai vat tu xa");
        gc.npc[0].setTalk(6,"Old man: Dung si su dung linh hoat nhung loai\nvu khi\nVa khi Dung si tieu diet quai va thi\nDung si con co the kiem duoc chut it\ntu chung");
        gc.npc[0].setTalk(7,"Dung si: Cam on ong lao da cho ta vu khi\nTa hua xe pha dao game nay de khong con\nquai vat nua\nTa di day");
        i = 2;
        minimonsterSheet = new SpriteSheet("res/entity/monsters.png", 24, 24);
        gc.origin[i] = new Vector2f(-50,250);
        setNPC(i,gc.origin[i],new SpriteSheet(minimonsterSheet.getSprite(0,9,128,16),16,16),48,"Guide");
        gc.npc[2].setBox(400);
        
        i = 3;
        SpriteSheet tinyMoonSheet = new SpriteSheet("res/entity/mon1_sprite.png", 50, 50);
        gc.origin[i] = new Vector2f(1000, 1000);
        setTinyMoon( i, gc.origin[i], tinyMoonSheet, 64);
    }

    @Override
    public void setMaterialPosition() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void resetEnemy(int i) {
        // TODO Auto-generated method stub
        
    }
}
        
