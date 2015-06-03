package bloqBreaker;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;
import org.lwjgl.openal.AL;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class Play {
	
	//int to know the current screen
	private static int currentScreen = 1;
	public static int xraton;
	public static int yraton;
	//load the menu image
	private static ImageBoss menu_botones; 
	//load menu button 1
	private static ImageBoss boton1;
	//load menu boton2
	private static ImageBoss boton2;
	//load menu button 3
	private static ImageBoss boton3;
	//load menu button 4
	private static ImageBoss boton4;
	
	
	//load the menu audio
	private static SoundBoss audio_menu;
	
	//load the button sound 
	private static SoundBoss audio_boton;
	
	// to put text
	private static TextBoss texto;
	
	public static void main(String[] args) {
		
		Display.setVSyncEnabled(true);
		//opengl starts here
		initGL(800, 500);
		texto = new TextBoss();
		
		texto.render("cargando historias", 20, 60);
		Display.update();
		
		//load all the stories (can <must> be improved for performance)
		Historias historias = new Historias();
		
		glClear(GL_COLOR_BUFFER_BIT);
		texto.render("cargando niveles", 40, 90);
		Display.update();
		
		Niveles niveles = new Niveles();
		
		glClear(GL_COLOR_BUFFER_BIT);
		texto.render("cargando imagenes", 60, 120);
		Display.update();
		
		menu_botones = new ImageBoss("JPG","imagenes/menu_botones.jpg");
		boton1 = new ImageBoss("PNG","imagenes/boton1.png");
		boton2 = new ImageBoss("PNG","imagenes/boton2.png");
		boton3 = new ImageBoss("PNG","imagenes/boton3.png");
		boton4 = new ImageBoss("PNG","imagenes/boton4.png");
		
		glClear(GL_COLOR_BUFFER_BIT);
		texto.render("cargando musica", 80, 150);
		Display.update();
		
		audio_menu = new SoundBoss("WAV","musica/brasileiro.wav");
		audio_boton = new SoundBoss("WAV","musica/Droplet.wav");
		
		
		audio_menu.playSound(SoundBoss.PLAY_AS_MUSIC);
	
		while(!Display.isCloseRequested()){
				
			glClear(GL_COLOR_BUFFER_BIT);
			menu_botones.print(0,0);
			
			switch(currentScreen){
			
			case 0://this could be an intro or loading screen
			    
			case 1: //it's in the menu
				menuLogic();
			    break;
			    
			case 2: //it's in the new game
				historias.putHistory1();
				if(niveles.playLevel1()){
					historias.putHistory2();
					if(niveles.playLevel2()){
						historias.putHistory3();
					}else{
						audio_menu.playSound(SoundBoss.PLAY_AS_MUSIC);
					}
				}else{
					audio_menu.playSound(SoundBoss.PLAY_AS_MUSIC);
				}
				currentScreen = 1;
				break;
			case 3: //it's in the select level screen
				selectLevelLogic();
				break;
			case 4: //it's in the level 2 screen
				historias.putHistory2();
				if(niveles.playLevel2()){
					historias.putHistory3();
				}else{
					audio_menu.playSound(SoundBoss.PLAY_AS_MUSIC);
				}
				currentScreen = 1;
				break;
				
				
			default:
				break;
			}
			
			Display.update();
			Display.sync(60); 
		}
		Display.destroy();
		AL.destroy();

	}



private static void initGL(int width, int height) {
	try {
		Display.setDisplayMode(new DisplayMode(width,height));
		Display.create();
		Display.setVSyncEnabled(true);
		Display.setTitle("Bloq Breaker");
		
		
	} catch (LWJGLException e) {
		e.printStackTrace();
		System.exit(0);
  }

	
//	GL11.glViewport(0,0, width, height);
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
//	glOrtho( 0, 1024, 512, 0, 1, -1);
	glOrtho(0, width, height, 0, 1, -1);
//	//glMatrixMode(GL_MODELVIEW);
	glEnable(GL_TEXTURE_2D);
	glDisable(GL_DEPTH_TEST);
	glEnable(GL11.GL_BLEND);
	GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
}

private static void selectLevelLogic(){
	glClear(GL_COLOR_BUFFER_BIT);
	xraton = Mouse.getX();
	yraton = Mouse.getY();
	texto.render("1. the mission", 40, 90);
	texto.render("2. Ain't leaving you",40, 140);
	texto.render("Back to Menu", 60, 200);
	if(Mouse.isButtonDown(0)){
		if(yraton < 409  && yraton > 384){ //play level 1
			audio_boton.playSound(SoundBoss.PLAY_AS_SOUND);
			currentScreen = 2;
			pause(250);
		}
		else if(yraton < 358 && yraton > 334 ){ //play level 2
			audio_boton.playSound(SoundBoss.PLAY_AS_SOUND);
			currentScreen = 4;
			pause(250);
		}
		else if(yraton < 296 && yraton > 274 ){ //go to the menu
			//audio_boton.playSound(2);
			currentScreen = 1;
			Display.update();
		}
	}
	
}

private static void menuLogic(){
   xraton = Mouse.getX();
   yraton = Mouse.getY();

   
   if(xraton<216 && xraton>16){ 
	    if(yraton>18 && yraton<118){
	    	boton4.print(16, 382);
	    	if(Mouse.isButtonDown(0)){ //the exit button
	    		audio_boton.playSound(SoundBoss.PLAY_AS_SOUND);
	    		pause(250);
	    		AL.destroy();
	    		Display.destroy();
	    		System.exit(0);
	    	}
	    }
	    else if(yraton>141 && yraton<241){ //the levels button
	    	boton3.print(16 , 261);
	    	if(Mouse.isButtonDown(0)){
	    		audio_boton.playSound(SoundBoss.PLAY_AS_SOUND);
	    		currentScreen = 3;
	    		pause(250);
	    		Display.update();   
	    	}
	    	
	    }
	    else if(yraton>261 && yraton<361){ //the scores button
           boton2.print(16,141);
	    	if(Mouse.isButtonDown(0)){
	    		audio_boton.playSound(SoundBoss.PLAY_AS_SOUND);
	    		pause(250);
	    		Display.update();   
	    	}
	    	
	    }
	    else if(yraton>382 && yraton<482){ //the new game button
	    	boton1.print(16, 18);
	    	if(Mouse.isButtonDown(0)){
	    		audio_boton.playSound(SoundBoss.PLAY_AS_SOUND);
	    	    currentScreen = 2;
	    		pause(250);
	    		Display.update();   
	    	}
	    }
   }
   
}


//pause in miliseconds
public static void pause(long time) {
  int SLEEP_DELAY = 100;
  for (int i = 0; i < time; i += SLEEP_DELAY) {
  try {
	  Display.processMessages();
	  Thread.sleep(SLEEP_DELAY);
  } catch (InterruptedException inte) {
  	}
  }
}


}