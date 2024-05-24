package main;

import entity.Alien;
import entity.Boss;
import entity.Bullet;


public class Setter {
     Panel p;
     public Setter(Panel p){
        this.p=p;
     }
     //cài vị trí ban đầu của quái
     public void setAlien(){
        for(int i=0;i<4;i++){
            for(int j=0;j<6;j++){
            p.alien[i][j]=new Alien((j+1)*100,(i+2)*50,(j+1)*100,p);
            p.alien[i][j].speed=p.score/72+1;
        }}
   }
      public void setAlien_lv2(){
          for(int i=0;i<4;i++){
             for(int j=0;j<6;j++){
              p.alien[i][j]=new Alien((j+1)*100,(i+2)*50,(j+1)*100,p);
              p.alien[i][j].speed=p.score/72+1;
      }}
 }
     
     //cài các thông số ban đầu của Bullet
     public void setBullet(){
      for(int i=0;i<5;i++){
         p.bullet[i]=new Bullet(p);
      }
  }
      public void setBullet_lv3(){
      for(int i=0;i<5;i++){
      p.bullet[i]=new Bullet(p);
      p.bullet[i].index=i;
      p.bullet[i].x=p.boss.x+p.boss.width/2-p.bullet[i].width/2;
      p.bullet[i].y=p.boss.y+p.boss.height-p.bullet[i].height;
   } 
}
     //cài vị trí ban đầu của boss
      public void setBoss(){
      p.boss=new Boss(p);
      
    }
}