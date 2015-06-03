package bloqBreaker;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

public class Base extends Entity {

	private boolean moving = false;
	private boolean seMovioDerecha; 
	
	public boolean ismoving(){
		return moving;
	}
	public boolean movDer(){
		return seMovioDerecha;
	}
	
	public Base(int width, int heigth){
		super(width, heigth);
		x = 324;
		y = Display.getHeight()-heigth;
		DX = 2;
	}
	
	public void mover() {
		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)){
			if((x+width+DX)<= Display.getWidth()){
				x += DX;
				if(!seMovioDerecha)DX=2;
				seMovioDerecha = true;
				if(DX < 9)DX += 0.3f;
				moving = true;
			}
			
		}
		else if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)){
			if((x+DX)>=0 ){
				x -= DX;
				if(seMovioDerecha)DX=2;
				seMovioDerecha = false;
				if(DX < 9 )DX +=0.3f;
				moving = true;
			}

		}
		else{
			moving = false;
			DX = 2;
		}
		
	}
}
