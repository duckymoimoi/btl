package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;
import javax.swing.ImageIcon;

import main.Panel;

public class Boss extends Sprite {
    private ImageIcon bossImage;
    Panel p;
    public int sangphai=1;
    public double countDown1=0;
    public double countDown2=0;
    public int change;
    public int life=24;
    Random generator=new Random();
    public Boss(Panel p){
        this.p=p;
        width=100;
        height=100;
        speed=2;
        x=1000;
        y=1000;
        alive=false;
        bossImage = new ImageIcon(getClass().getResource("/Image/Boss.gif"));
    }
    
    public void update(){
        if(alive==true){
        if(x>=450&&sangphai==1){
            sangphai=0;
            countDown2=60;
        }
        else if(x<=50&&sangphai==0){
            sangphai=1;
            countDown2=60;
        }
        if(countDown2==0){
            sangphai=generator.nextInt(2);
            countDown2=60;
        }
        
        if(sangphai==1&&countDown2>0){x+=speed;countDown2--;}
        else if(sangphai==0&&countDown2>0){x-=speed;countDown2--;}
        }
    }
    public void draw(Graphics2D g2){
        if(alive==true){
            g2.drawImage(bossImage.getImage(),x,y,null);
        }

    }
}
