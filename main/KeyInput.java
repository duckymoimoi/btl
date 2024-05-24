package main;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener  {
    Panel p;
    public boolean upPressed;
    public boolean downPressed;
    public boolean leftPressed;
    public boolean rightPressed;
    public boolean spacePressed;
    public boolean change=false;public boolean select=false;
    public KeyInput(Panel p){
        this.p =p;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (p.gameState == p.menuState) {
            
            if (code == KeyEvent.VK_W||code == KeyEvent.VK_UP) {
                p.ui.comN--;
                if(p.ui.comN<0){
                    p.ui.comN=2;
                }
            } else if (code == KeyEvent.VK_S ||code == KeyEvent.VK_DOWN) {
                p.ui.comN++;
                change=true;
                if(p.ui.comN>2){
                    p.ui.comN=0;
                }
            } else if (code == KeyEvent.VK_ENTER){
                if(p.ui.comN==0){
                    p.gameState=p.playState;
                    select=true;
                }
                if (p.ui.comN==1){
                    p.gameState=p.helpState;
                    select=true;

                }
                if (p.ui.comN==2){
                    select=true;
                    System.exit(0);
                }
            }
        } else if (p.gameState==p.helpState) {
            if(code ==KeyEvent.VK_ESCAPE){
                p.gameState=p.menuState;
                change=true;
            }

        } 
        else if (p.gameState == p.playState) {
            if(code ==KeyEvent.VK_ESCAPE){
                change=true;
                System.exit(0);
            }

            if (code == KeyEvent.VK_W) {
                upPressed = true;
            } else if (code == KeyEvent.VK_S) {
                downPressed = true;
            } else if (code == KeyEvent.VK_A) {
                leftPressed = true;
            } else if (code == KeyEvent.VK_D) {
                rightPressed = true;
            } else if (code == KeyEvent.VK_SPACE) {
                spacePressed = true;
            }

            if (code == KeyEvent.VK_P) {
                if (p.gameState == p.playState) {
                    change=true;
                    p.gameState = p.pauseState;
                  
                }
            }
            if (code == KeyEvent.VK_NUMPAD0){
                p.gameState = p.gameOverState; // For debugging purpose
            }
        } 
        else if(p.gameState==p.pauseState){
            if (code == KeyEvent.VK_P){
                 if (p.gameState == p.pauseState) {
                    change=true;
                    p.gameState = p.playState;
                }
              
            }
            else if(code == KeyEvent.VK_B){
                if (p.gameState == p.pauseState) {
                    p.gameState = p.menuState;
                  p.resetGame();
                }
                
            }
        }
        else if (p.gameState == p.gameOverState) {
            if (code == KeyEvent.VK_D || code == KeyEvent.VK_A ) {
                if (p.ui.comN == 0) {
                    change=true;
                    p.ui.comN = 1;
                }
                else if (p.ui.comN == 1) {
                    change=true;
                    p.ui.comN = 0;
                }
            }
            if (code == KeyEvent.VK_ENTER) {
                if (p.ui.comN == 0) {
                    p.ResetGame();
                    p.gameState = p.playState;
                    select=true;
                }
                if (p.ui.comN == 1) {
                    p.ResetGame();
                    p.ui.comN = 0;
                    p.gameState = p.menuState;
                    select=true;
            }
        }
    }
}
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
      if (code == KeyEvent.VK_W) {
         upPressed = false;
      }

      else if (code == KeyEvent.VK_S) {
         downPressed = false;
      }

      else if (code == KeyEvent.VK_A) {
         leftPressed = false;
      }

      else if (code == KeyEvent.VK_D) {
         rightPressed = false;
      }
      else if (code == KeyEvent.VK_SPACE){
         spacePressed = false;
      }
    }
    }





