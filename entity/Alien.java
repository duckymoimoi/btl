package entity;


import java.awt.Graphics2D;
import main.Panel;
import javax.swing.ImageIcon;



public class Alien extends Sprite {
    public int x0;
    Panel p;
    public boolean sangphai=true;
    private ImageIcon alienSkin1;
    public Alien(int x,int y,int x0,Panel p){
        this.x0=x0;
        this.x=x;
        this.y=y;
        this.p=p;
        setDefaultValue();
    }
    public void setDefaultValue(){
        speed=1;
        width=32;
        height=32;
        alive=true;
    }
    public void changeDirection() {
        for(int i=0;i<4;i++){
            for(int j=0;j<6;j++){
                p.alien[i][j].sangphai = !p.alien[i][j].sangphai;
                if(p.alien[i][j].sangphai){
                    p.alien[i][j].x -= speed; // đi sang phải
                    p.alien[i][j].y += 15;
                } else {
                    p.alien[i][j].x += speed; // di sang trái
                }
                if(p.alien[i][j].y >= p.player.y-p.player.height) {
                    p.gameState = p.gameOverState; // Đặt trạng thái trò chơi thành kết thúc
                }
            }
        }
    }
    
    public void update(){
        if(alive){
            if(sangphai){
                x += speed;
                if(x >= p.getWidth() - width) {
                    changeDirection();
                }
            } else {
                x -= speed;
                if(x <= 0) {
                    changeDirection();
                }
            } 
        } 
        else{
            x=-1000;
            y=-1000;
        }
    }
    
    public void draw(Graphics2D g2){
        if(alive==true){
        alienSkin1 = new ImageIcon(getClass().getResource("/Image/AlienSkin1.gif"));
        g2.drawImage(alienSkin1.getImage(), x, y, null);
        }
    }

}


