package game.util;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {
    Clip clip;
    URL soundURL[]= new URL[30];

    public Sound() {
        //change file music for game!!!!!!!!!!!
        soundURL[0]= getClass().getResource("/res/sound/Our-Mountain.wav");
        soundURL[1]= getClass().getResource("/res/sound/coin.wav");
        soundURL[2]= getClass().getResource("/res/sound/powerup.wav");
        soundURL[3]= getClass().getResource("/res/sound/unlock.wav");
        soundURL[4]= getClass().getResource("/res/sound/fanfare.wav");
        soundURL[5]= getClass().getResource("/res/sound/hitmonster.wav");
        soundURL[6]= getClass().getResource("/res/sound/receivedamage.wav");
        soundURL[7]= getClass().getResource("/res/sound/swingweapon.wav");
        soundURL[8]= getClass().getResource("/res/sound/levelup.wav");
        soundURL[9]= getClass().getResource("/res/sound/cursor.wav");
        soundURL[10]= getClass().getResource("/res/sound/burning.wav");
    }
    private void setFile(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        }catch(Exception e) {
            System.out.println("ERROR: Can't load audio" + soundURL[i]);
        }
    }
    private void play() {
        clip.start();
    }
    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop() {
        if(clip != null) clip.stop();
    }
    public void playLoopMusic(int i) {
        setFile(i);
        play();
        loop();
    }
    public void stopMusic() {
        stop();
    }
    public void playSingleMusic(int i) {
        setFile(i);
        play();
    }
}
