package bloqBreaker;

import org.lwjgl.input.Keyboard;
import org.lwjgl.openal.AL;
import org.lwjgl.opengl.Display;

public class Historias {

	//images for histories
	private static ImageBoss imagen1_1;
	private static ImageBoss imagen1_2;
	private static ImageBoss imagen1_3;
	private static ImageBoss imagen1_4;
	private static ImageBoss imagen1_5;
	private static ImageBoss imagen1_6;
	private static ImageBoss imagen1_7;
	private static ImageBoss imagen1_8;
	private static ImageBoss imagen1_9;
	private static ImageBoss imagen1_10;
	private static ImageBoss imagen1_11;
	
	private static ImageBoss imagen2_1;
	private static ImageBoss imagen2_2;
	private static ImageBoss imagen2_3;
	private static ImageBoss imagen2_4;
	private static ImageBoss imagen2_5;
	
	private static ImageBoss imagen3_1;
	private static ImageBoss imagen3_2;
	private static ImageBoss imagen3_3;
	private static ImageBoss imagen3_4;
	private static ImageBoss imagen3_5;
	private static ImageBoss imagen3_6;
	
	//music
	private static SoundBoss musica_historia1;
	private static SoundBoss musica_historia2;
	private static SoundBoss musica_historia3;
	
	
	
	public Historias(){
		//history 1
	   imagen1_1 = new ImageBoss("JPG","historia/chibola.jpg");
	   imagen1_2 = new ImageBoss("JPG","historia/chibola2.jpg");
	   imagen1_3 = new ImageBoss("JPG","historia/chibola4.jpg");
	   imagen1_4 = new ImageBoss("JPG","historia/chibola5.jpg");
	   imagen1_5 = new ImageBoss("JPG","historia/chibola6.jpg");
	   imagen1_6 = new ImageBoss("JPG","historia/chibola7.jpg");
	   imagen1_7 = new ImageBoss("JPG","historia/chibola8.jpg");
	   imagen1_8 = new ImageBoss("JPG","historia/chibola9.jpg");
	   imagen1_9 = new ImageBoss("JPG","historia/chibola11.jpg");
	   imagen1_10 = new ImageBoss("JPG","historia/chibola12.jpg");
	   imagen1_11 = new ImageBoss("JPG","historia/chibola13.jpg");
	   //
	   
	   //history 2
	   imagen2_1 = new ImageBoss("JPG","historia/chibola15.jpg");
	   imagen2_2 = new ImageBoss("JPG","historia/chibola16.jpg");
	   imagen2_3 = new ImageBoss("JPG","historia/chibola17.jpg");
	   imagen2_4 = new ImageBoss("JPG","historia/chibola18.jpg");
	   imagen2_5 = new ImageBoss("JPG","historia/chibola19.jpg");
	   
	   
	   //history 3
	   imagen3_1 = new ImageBoss("JPG","historia/chibola20.jpg");
	   imagen3_2 = new ImageBoss("JPG","historia/chibola22.jpg");
	   imagen3_3 = new ImageBoss("JPG","historia/chibola23.jpg");
	   imagen3_4 = new ImageBoss("JPG","historia/chibola24.jpg");
	   imagen3_5 = new ImageBoss("JPG","historia/chibola25.jpg");
	   imagen3_6 = new ImageBoss("JPG","historia/chibola26.jpg");
	   
	   //music
	   musica_historia1 = new SoundBoss("WAV","musica/historia1.wav");
	   musica_historia2 = new SoundBoss("WAV","musica/historia2.wav");
	   musica_historia3 = new SoundBoss("WAV","musica/final.wav");
	   
	}
	
	public void putHistory1(){
		   musica_historia1.playSound(1);
		   for (int i = 0; i < 1; i++) {
			
			if(Keyboard.isKeyDown(Keyboard.KEY_RETURN)){
				break;
			}
			checkDispExit();
			imagen1_1.print(0, 0);
			Display.update();
			Play.pause(3000);
			
			if(Keyboard.isKeyDown(Keyboard.KEY_RETURN)){
				break;
			}
			checkDispExit();
			imagen1_2.print(0, 0);
			Display.update();
			Play.pause(3000);
			
			if(Keyboard.isKeyDown(Keyboard.KEY_RETURN)){
				break;
			}
			checkDispExit();
			imagen1_3.print(0, 0);
			Display.update();
			Play.pause(3000);
			
			if(Keyboard.isKeyDown(Keyboard.KEY_RETURN)){
				break;
			}
			checkDispExit();
			imagen1_4.print(0, 0);
			Display.update();
			Play.pause(3000);
			
			if(Keyboard.isKeyDown(Keyboard.KEY_RETURN)){
				break;
			}
			checkDispExit();
			imagen1_5.print(0, 0);
			Display.update();
			Play.pause(3000);
			
			if(Keyboard.isKeyDown(Keyboard.KEY_RETURN)){
				break;
			}
			checkDispExit();
			imagen1_6.print(0, 0);
			Display.update();
			Play.pause(3000);
			
			if(Keyboard.isKeyDown(Keyboard.KEY_RETURN)){
				break;
			}
			checkDispExit();
			imagen1_7.print(0, 0);
			Display.update();
			Play.pause(3000);
			
			if(Keyboard.isKeyDown(Keyboard.KEY_RETURN)){
				break;
			}
			checkDispExit();
			imagen1_8.print(0, 0);
			Display.update();
			Play.pause(3000);
			
			if(Keyboard.isKeyDown(Keyboard.KEY_RETURN)){
				break;
			}
			checkDispExit();
			imagen1_9.print(0, 0);
			Display.update();
			Play.pause(3000);
			
			if(Keyboard.isKeyDown(Keyboard.KEY_RETURN)){
				break;
			}
			checkDispExit();
			imagen1_10.print(0, 0);
			Display.update();
			Play.pause(3000);
			
			if(Keyboard.isKeyDown(Keyboard.KEY_RETURN)){
				break;
			}
			checkDispExit();
			imagen1_11.print(0, 0);
			Display.update();
			Play.pause(3000);
		}
		   
	}
	
	public void putHistory2(){
		musica_historia2.playSound(1);
		for (int i = 0; i <1; i++) {
			
			
			if(Keyboard.isKeyDown(Keyboard.KEY_RETURN)){
				break;
			}
			checkDispExit();
			imagen2_1.print(0, 0);
			Display.update();
			Play.pause(3000);
			
			if(Keyboard.isKeyDown(Keyboard.KEY_RETURN)){
				break;
			}
			checkDispExit();
			imagen2_2.print(0, 0);
			Display.update();
			Play.pause(3000);
			
			if(Keyboard.isKeyDown(Keyboard.KEY_RETURN)){
				break;
			}
			checkDispExit();
			
			imagen2_3.print(0, 0);
			Display.update();
			Play.pause(3000);
			if(Keyboard.isKeyDown(Keyboard.KEY_RETURN)){
				break;
			}
			checkDispExit();
			
			imagen2_4.print(0, 0);
			Display.update();
			Play.pause(3000);
			if(Keyboard.isKeyDown(Keyboard.KEY_RETURN)){
				break;
			}
			checkDispExit();
			
			imagen2_5.print(0, 0);
			Display.update();
			Play.pause(3000);
		}
		   
	}
	
	public void putHistory3(){
		musica_historia3.playSound(1);
		for (int i = 0; i < 1; i++) {
			
			imagen3_1.print(0, 0);
			Display.update();
			Play.pause(3000);
			if(Keyboard.isKeyDown(Keyboard.KEY_RETURN)){
				break;
			}
			checkDispExit();
			
			imagen3_2.print(0, 0);
			Display.update();
			Play.pause(3000);
			if(Keyboard.isKeyDown(Keyboard.KEY_RETURN)){
				break;
			}
			checkDispExit();
		
			imagen3_3.print(0, 0);
			Display.update();
			Play.pause(3000);
			if(Keyboard.isKeyDown(Keyboard.KEY_RETURN)){
				break;
			}
			checkDispExit();
			
			imagen3_4.print(0, 0);
			Display.update();
			Play.pause(3000);
			if(Keyboard.isKeyDown(Keyboard.KEY_RETURN)){
				break;
			}
			checkDispExit();
			
			imagen3_5.print(0, 0);
			Display.update();
			Play.pause(3000);
			if(Keyboard.isKeyDown(Keyboard.KEY_RETURN)){
				break;
			}
			checkDispExit();
			
			imagen3_6.print(0, 0);
			Display.update();
			Play.pause(3000);
		}
		   
	}
	
	private void checkDispExit(){
		if(Display.isCloseRequested()){
			Display.destroy();
			AL.destroy();
			System.exit(0);
		}
	}
	
}
