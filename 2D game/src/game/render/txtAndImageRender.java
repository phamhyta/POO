package game.render;
import java.awt.*;
import game.graphics.Sprite;
import java.awt.image.BufferedImage;
import static game.states.GameStateManager.fontf;

public class TxtAndImageRender{
    private String txt;
    private double txtTran;
    private Sprite image[];
    private int stateOfImage;
    private double Tran;
    private BufferedImage imageintro[];

    public TxtAndImageRender(String txt) {
        this.txt = txt;
        this.Tran = 0;
    }
    public TxtAndImageRender(Sprite image[]) {
        this.image = image;
        this.stateOfImage = 0;
        this.Tran = 255;
    }
    public TxtAndImageRender(BufferedImage image[]){
        this.imageintro = image;
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
            int check = 0;
            if(count<=(timeBegin+2)*60){
                check = 1;
            }
            if(count>(timeEnd-2)*60){
                check = -1;
            }
            
            double time1 = 2*60;
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
    public void RenderImage(Graphics2D g,int timeBegin,int timeEnd,int ScreenX,int ScreenY,int Width,int Height,int count){
        if(count>timeBegin*60&&count<=timeEnd*60){
            if(count%20==0){
                this.stateOfImage++;
                if(this.stateOfImage==3){
                    this.stateOfImage=0;
                }
            }
            g.drawImage(this.image[this.stateOfImage].image,ScreenX , ScreenY,Width,Height,null);
            if((timeEnd-4)*60 <count&&count <= (timeEnd)*60){
                double k2 = 255.0/240.0;
                this.Tran += k2;
                g.setColor(( new Color(0,0,0,(int) this.Tran)));
                g.fillRect(ScreenX, ScreenY, Width, Height);
            }
            if(count<=(timeBegin+4)*60){
                double k2 =  255.0/240.0;
                this.Tran -= k2;
                g.setColor(( new Color(0,0,0,(int) this.Tran)));
                g.fillRect(ScreenX, ScreenY, Width, Height);
            }
    }
    }
    public void renderFirstInro(Graphics2D g,int count){
        double index = (double) count / (20*60/ 50.0);
        if(count <= 20*60){
            g.drawImage(this.imageintro[(int) index], 0, 0,null );
        }
        if(16*60 <count&&count <= 20*60){
            double k = 255.0/240.0;
            this.Tran += k;
            g.setColor(( new Color(0,0,0,(int) this.Tran)));
            g.fillRect(0, 0, 1280, 720);
        }
        if(count<=4*60){
            double k =  255.0/240.0;
            this.Tran -= k;
            g.setColor(( new Color(0,0,0,(int) this.Tran)));
            g.fillRect(0, 0, 1280, 720);
        }
    }
}
