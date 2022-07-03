package game.render;

import java.awt.*;
import static game.states.GameStateManager.fontf;

public class txtAndImageRender{
    private String txt;
    private double txtTran;
    public txtAndImageRender(String txt) {
        this.txt = txt;
        this.txtTran = 0;
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
            g.setFont(g.getFont().deriveFont(size));
            for(String line: txt.split("\n")){
                g.drawString(line, ScreenX, ScreenY);
                ScreenY+=48;
        }
    }    
    }

}
