package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import main.Panel;

import main.KeyInput;

public class Bomb extends Sprite {
    Panel p;
    KeyInput kIP;
    public double countDown=0;
    public Boolean destroyed=false;
    public boolean shot=false;

    public boolean alive=false;
    public Bomb (Panel p,KeyInput kIP){
        this.p=p;
        this.kIP=kIP;
        setDefaultValue();
    }
    public void setDefaultValue(){
        this.x=2000;
        this.y=2000;
        speed=30;
        this.width=4;
        this.height=8;
        this.alive=false;
    }
    public void update(){
        if(kIP.spacePressed==true&&alive==false&&countDown<=0){
            alive=true;
            shot=true;
            x=p.player.x+26;
            y=600;
            countDown=p.screenHight/speed;
        }
        else if(alive==true){
            y-=speed;
        }
        if(y<=0){setDefaultValue();}
        countDown-=1;
    }
    public void draw(Graphics2D g2){
        g2.setColor(Color.white);
        g2.fillRect(x,y,width,height);
    }
    
}

