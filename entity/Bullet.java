package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

import main.Panel;

public class Bullet extends Sprite {
    Panel p;
    public double countDown=0;
    public int index;
    public Bullet (Panel p){
        this.p=p;
        this.speed=4;
        setDefaultValue();
    }

    public void setDefaultValue(){
        this.x=2000;
        this.y=2000;
        this.width=8;
        this.height=16;
        this.alive=false;
    }
    public void update(){
        if(alive==false&&countDown<=0){
            alive=true;
            Random generator=new Random();
            int value1=generator.nextInt(4);
            int value2=generator.nextInt(6);
            x=p.alien[value1][value2].x+12;
            y=p.alien[value1][value2].y+32;
            if(speed<10){speed=4+p.score*2/72;}
            countDown=300/speed;
        }
        else if(alive==true){
            y+=speed;
        }
        if(y>=700){setDefaultValue();}
        countDown-=1;
    }
    public void update_lv3(){
        if(alive==false&&countDown<=0){
            alive=true;
            x=p.boss.x+p.boss.width/2-width/2;
            y=p.boss.y+p.boss.height-height;;
            countDown=p.screenHight/speed;
        }
        else if(alive==true){
            if(index==0){
                x-=5;
                y+=(int)(5*Math.sqrt(3));
            }
            else if(index==1){
                x-=(int)(10*Math.cos(1.22));
                y+=(int)(10*Math.sin(1.22));
            }
            else if(index==2){
                y+=10;
            }
            else if(index==3){
                x+=(int)(10*Math.cos(1.22));
                y+=(int)(10*Math.sin(1.22));
            }
            else if(index==4){
                x+=5;
                y+=(int)(5*Math.sqrt(3));
            }
            
        }
        if(y>=700){setDefaultValue();}
        countDown-=1;
    }
    public void draw(Graphics2D g2){
        g2.setColor(Color.green);
        g2.fillRect(x,y,width,height);
    }
}
