package game.render;

import java.awt.*;
import java.nio.Buffer;

import game.graphics.Sprite;
import game.graphics.SpriteSheet;

import static game.states.GameStateManager.fontf;

public class txtAndImageRender{
    private String txt;
    private double txtTran;
    private SpriteSheet image[][];
    private int stateOfImage;
    private double Tran;
    public txtAndImageRender(String txt) {
        this.txt = txt;
        this.Tran = 0;
    }
    public txtAndImageRender(SpriteSheet image[][]) {
        this.image = image;
        this.stateOfImage = 0;
        this.Tran = 255;
    }
    

    public void renderTxt(Graphics2D g,int timeBegin,int timeEnd,int ScreenX,int ScreenY,int count){
        if(count>timeBegin*60 && count<=timeEnd*60){
            int check;
            if(count<=(timeBegin+timeEnd)*30){
                check = 1;
            }
            else{
                check = -1;
            }
            double time1 = (timeEnd-timeBegin)*60/2;
            double timeTran = (double) 255/(time1);
            this.txtTran =this.txtTran+ timeTran*check;
            g.setColor(new Color(255,255,255,(int) this.txtTran));
            g.setFont(fontf.getFont("MeatMadness"));
            g.setFont(g.getFont().deriveFont(30F));   
            for(String line: txt.split("\n")){
                g.drawString(line, ScreenX, ScreenY);
                ScreenY+=48;
        }
    }    
    }
    public void renderTxt(Graphics2D g,int timeBegin,int timeEnd,int ScreenX,int ScreenY,int count,float size){
        if(count>timeBegin*60 && count<=timeEnd*60){
            int check;
            if(count<=(timeBegin+timeEnd)*30){
                check = 1;
            }
            else{
                check = -1;
            }
            double time1 = (timeEnd-timeBegin)*60/2;
            double timeTran = (double) 255/(time1);
            this.txtTran =this.txtTran+ timeTran*check;
            g.setColor(new Color(255,255,255,(int) this.txtTran));
            g.setFont(fontf.getFont("MeatMadness"));
            g.setFont(g.getFont().deriveFont(size));
            for(String line: txt.split("\n")){
                g.drawString(line, ScreenX, ScreenY);
                ScreenY+=48;
        }
    }    
    }
    public void RenderImage(Graphics2D g,int timeBegin,int timeEnd,int ScreenX,int ScreenY,int Width,int Height,int count,int obj){
        if(count>timeBegin*60&&count<=timeEnd*60){
            if(count%20==0){
                this.stateOfImage++;
                if(this.stateOfImage==4){
                    this.stateOfImage=0;
                }
            }
            // g.drawImage(this.image[obj][this.stateOfImage].image,ScreenX , ScreenY,Width,Height,null);
            if((timeEnd-4)*60 <count&&count <= (timeEnd)*60){
                double k2 = 255.0/240.0;
                this.Tran += k2;
                g.setColor(( new Color(0,0,0,(int) this.Tran)));
                g.fillRect(0, 0, 1280, 720);
            }
            if(count<=(timeBegin+4)*60){
                double k2 =  255.0/240.0;
                this.Tran -= k2;
                g.setColor(( new Color(0,0,0,(int) this.Tran)));
                g.fillRect(0, 0, 1280, 720);
            }
    }
    }
}
