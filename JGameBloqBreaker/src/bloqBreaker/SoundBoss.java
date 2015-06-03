package bloqBreaker;

import java.io.IOException;

import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.util.ResourceLoader;

public class SoundBoss {
	
	//music tracks are play different if they are background music (repeats) or just and effect
	public static final int PLAY_AS_MUSIC = 1;
	public static final int PLAY_AS_SOUND = 2; 
	
	private Audio sound;
	
	public SoundBoss(String format, String location){
		try {
			sound = AudioLoader.getAudio(format,ResourceLoader.getResourceAsStream(location));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void playSound(int type){
		if(type == PLAY_AS_MUSIC ){
			sound.playAsMusic(1.0f, 1.0f, true);
		}
		if(type == PLAY_AS_SOUND ){
			sound.playAsSoundEffect(1.0f, 1.0f, false);
		}
	}
}
