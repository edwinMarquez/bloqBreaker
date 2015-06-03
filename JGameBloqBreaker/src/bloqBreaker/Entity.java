package bloqBreaker;


//general class of elements that has a position on the screen and acceleration
public class Entity {

	protected int x=0;
	protected int y=0;
	protected float DX=0;
	protected float DY=0;
	protected int width;
	
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeigth() {
		return heigth;
	}

	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}

	protected int heigth;
	
	public Entity(int width, int heigth){
		this.width = width;
		this.heigth = heigth;
		
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	
	public void setY(int y){
		this.y = y;
	}
	
	public void setDX(float DX){
		this.DX = DX;
	}
	
	public void setDY(float DY){
		this.DY = DY;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public float getDX(){
		return DX;
	}
	
	public float getDY(){
		return DY;
	}
	
}
