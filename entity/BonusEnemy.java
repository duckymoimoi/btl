package entity;

import main.Panel;
import javax.swing.ImageIcon;
import java.awt.Graphics2D;
public class BonusEnemy extends Sprite{
    public int x0;
    public Panel p;
    private ImageIcon bonusEnemySkin;
    public BonusEnemy(int x, int y, Panel p){
        this.x = x;
        this.y=y;
        this.p=p;
        setDefaultValue();
    }
    public void setDefaultValue(){
        speed = 2;
        width = 50;
        height = 50;
        alive = true;

    }
    public int getXPosition() {
        return this.x;
    }

    public int getYPosition() {
        return this.y;
    }

    public void setXPosition(int xPosition) {
        this.x = xPosition;
    }

    public void setYPosition(int yPosition) {
        this.y = yPosition;
    }
    public void draw(Graphics2D g2){
        if(alive==true){
            bonusEnemySkin = new ImageIcon(getClass().getResource("/Image/bonusEnemy.gif"));
            g2.drawImage(bonusEnemySkin.getImage(), x, y, null);
        }
    }



}
