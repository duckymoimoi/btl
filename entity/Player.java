package entity;
import javax.swing.ImageIcon;
import main.KeyInput;
import main.Panel;
import java.awt.Graphics2D;

public class Player extends Sprite {
    private ImageIcon playerImage;
    private ImageIcon playerImageGETHIT;

    Panel p;
    KeyInput kIP;
    //phương thức khởi tạo
    public Player (Panel p,KeyInput kIP){
        this.p=p;
        this.kIP=kIP;
        setDefaultValue();
        playerImage = new ImageIcon(getClass().getResource("/Image/SpaceShip.png"));
        playerImageGETHIT = new ImageIcon(getClass().getResource("/Image/SpaceShipGETHIT.png"));
    }
    //vị trí ban đầu và tốc độ người chơi
    public void setDefaultValue(){
        x=326;
        y=600;
        speed=5;
        width=60;
        height=35;
        alive=true;
    }
    //cập nhật và vẽ hình ảnh
    public void update(){
        if(kIP.rightPressed==true&&x<652){
            x+=speed;
        }
        else if(kIP.leftPressed==true&&x>0){
            x-=speed;
        }
    }
    //Trạng thái màu sắc của player
    public void draw(Graphics2D g2) {
        if (isInvincible()) {
            long elapsed = (System.currentTimeMillis() - lastHitTime) % 250; // Thay đổi màu sắc mỗi 0.25 giây
            if (elapsed < 125) {
                g2.drawImage(playerImage.getImage(), x-9, y-22, null); // Vẽ hình ảnh bình thường
            }
            else{
                g2.drawImage(playerImageGETHIT.getImage(), x-9, y-22, null);
            }
        } else {
            g2.drawImage(playerImage.getImage(), x-9, y-22, null); // Vẽ hình ảnh bình thường
        }
    }
    //Khởi tạo mạng
    public int life = 3; // Số mạng ban đầu
    public int getLife() {
        return life;
    }

    public boolean isInvincible = false; // Trạng thái bất tử tạm thời
    public long lastHitTime; // Thời gian lần cuối bị trúng đạn
    public long invincibilityDuration = 1000; // Thời gian bất tử tạm thời (2 giây)

    public boolean isInvincible() {
        return isInvincible;
    }

    public void makeInvincible() {
        isInvincible = true;
        lastHitTime = System.currentTimeMillis();
    }

    public boolean isHit(Bullet bullet) {
        return (bullet.x + bullet.width >= x-20 && bullet.x <= x-20 + width &&
                bullet.y + bullet.height >= y && bullet.y <= y + height);
    }
    public void loseLife() {
        if (!isInvincible) { // Chỉ mất mạng khi không ở trạng thái bất tử
            life--;
            makeInvincible(); // Bắt đầu trạng thái bất tử tạm thời
            if (life == 0) {
                p.setGameOver(true); // Đặt trạng thái trò chơi thành kết thúc
            }
        }
    }

}