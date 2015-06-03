package bloqBreaker;

import org.lwjgl.opengl.Display;
  //ball logic
public class Pelota extends Entity {

	float radius;
    float centerX;
    float centerY;
    int vidas=4;
	
	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	public Pelota(int width, int height) {
		super(width, height);
		x= 50;
		y= 100;
		DX = 3f;  //3
		DY = -3f;
		
	}
	
	public boolean chocoPelotaLadrillo(int xladrillo, int yladrillo){
		
		//lado izquierdo del cubo_________________________
			if(x+22 >= xladrillo && x +22 < xladrillo + 42 && x < xladrillo && (y +22 > yladrillo && y +22 < yladrillo+27 || y > yladrillo && y < yladrillo+27)){
		        DX *= -1;
				//if(DX > 0)DX *= -1;
				return true;
				}

				

		//lado derecho del cubo____________________________________
			else if(DX < 0 && x > xladrillo && x <= xladrillo + 42 && x+22 > xladrillo +42 && ( y +22 > yladrillo && y +22 < yladrillo +27 || y > yladrillo && y < yladrillo +27)){
				DX *= -1;
				return true;
				}
		
		//choque con el borde superior_________________________________________________
		if((x > xladrillo && x < xladrillo+42 || x+22 > xladrillo && x +22 < xladrillo +42 ) && y+22 >= yladrillo && y +22 < yladrillo+27){ 
                        int resta = (y+22) - (yladrillo);
                        y -= (resta);
                        DY *= -1;
                        return true;
		}         

//choque con el borde inferior____________________________________
	    else if(y > yladrillo && y <= yladrillo + 27 && ( x > xladrillo &&  x < xladrillo +42 || x +22 > xladrillo && x +22 < xladrillo +42)){
	        DY *= -1;
	        return true;
		}

		return false;
	}
	
	
	public boolean ChoquePelotaBase(int xBase, int yBase, int widthBase, int heightBase){
		if((y + heigth -5)>= (Display.getHeight()-heightBase) && x+width > xBase && x < xBase+widthBase){
			if(DY>0)DY *= -1;
			return true;
			}
		return false;
	}
	
	public void choquePelotaLados(){
		//choque derecha
		if((x+width)>= Display.getWidth() && DX>0){
			DX *= -1;
		}
		//choque izquierda
		if((x<= 0) && DX < 0){
			DX *= -1;
		}
		//choque arriba
		if(y <= 0 && DY < 0){
			DY *= -1;
		}

		
	}

	public void mover() {
//		x += DX + ((DX>0)?(0.5f):(-0.5f));//DX+0.5;
//		y += DY + ((DY>0)?(0.7f):(-0.3f));
		x += DX;
		y += DY;
	}

	public boolean perdio(){
		//choque abajo
		if((y+2)>= Display.getHeight() && DY > 0){
			vidas -= 1;
			return true;
			}
		return false;
	}
	
	
}
