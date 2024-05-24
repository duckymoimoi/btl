package main;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Sound implements Runnable{
      Clip clip;
      URL soundURL[] = new URL[10];
      Panel p=new Panel();
      
      public Sound(Panel p){
        this.p=p;
        soundURL[0]=getClass().getResource("/sound/destruction.wav");
        soundURL[1]=getClass().getResource("/sound/deathSound.wav");
        soundURL[2]=getClass().getResource("/sound/switchButton.wav");
        soundURL[3]=getClass().getResource("/sound/interface.wav");
        soundURL[4]=getClass().getResource("/sound/shot.wav");
      }

      public void setFile(int i){
          try{
              AudioInputStream ais=AudioSystem.getAudioInputStream(soundURL[i]);
              clip = AudioSystem.getClip();
              clip.open(ais);

          }catch(Exception e){

          }

      }
      public void play(){
          clip.start();
      }
      public void loop(){
           clip.loop(Clip.LOOP_CONTINUOUSLY);
      }
      public void stop(){
        clip.stop();
      }

      @Override
      public void run() {
        double drawInterval = (double)(1000000000 / p.FPS);
      double delta = 0.0D;
      long lastTime = System.nanoTime();
      long timer = 0L;
      @SuppressWarnings("unused")
      int drawCount = 0;

      while(true) {
         long currentTime = System.nanoTime();
         delta += (double)(currentTime - lastTime) / drawInterval;
         timer += currentTime - lastTime;
         lastTime = currentTime;
         if (delta >= 1.0D) {
            if(p.bom.destroyed==true){
              setFile(0);
              play();
              p.bom.destroyed=false;
            }
            if(p.player.alive==false){
              setFile(1);
              play();
              p.player.alive=true;
            }
            if(p.KIP.change==true){
              setFile(2);
              play();
              p.KIP.change=false;
            }
            if(p.KIP.select==true){
              setFile(3);
              play();
              p.KIP.select=false;
            }
            if(p.bom.shot==true){
              setFile(4);
            FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            float volume = -10.0f;
            volumeControl.setValue(volume);
              play();
              p.bom.shot=false;
            }
            --delta;
            ++drawCount;
         }

         if (timer >= 1000000000L) {
            drawCount = 0;
            timer = 0L;
         }
      }
      }
      public void startSoundThread(){
        Thread soundThread = new Thread(this);
        soundThread.start();
    }


}
