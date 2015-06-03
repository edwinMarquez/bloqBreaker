package bloqBreaker;

import org.lwjgl.input.Keyboard;
import org.lwjgl.openal.AL;
import org.lwjgl.opengl.Display;

public class Niveles {
	
	boolean isCloseRequested=false;
	boolean goToMenu=false;
	boolean gano = false;
	int ladrillosDestruidos = 0;
	
	//images
	private static ImageBoss fondo_nivel1;
	private static ImageBoss fondo_nivel2;
	private static ImageBoss colchon;
	private static ImageBoss pelota;
    private static ImageBoss vida_1;
    private static ImageBoss vida_2;
    private static ImageBoss vida_3;
    private static ImageBoss vida_4;
    private static ImageBoss vida_completa;
    private static ImageBoss ladrillo_destruido;
    private static ImageBoss ladrillo_master;
    private static ImageBoss ladrillo_nivel2_destruido1;
    private static ImageBoss ladrillo_nivel2_destruido2;
    private static ImageBoss ladrillo_troll;
    private static ImageBoss ladrillo_troll1;
    private static ImageBoss ladrillo_troll2;
    private static ImageBoss ladrillo_troll3;
    private static ImageBoss ladrillo_troll4;
    private static ImageBoss ladrillo;
    
    //sound;
    private static SoundBoss musica_nivel1;
    private static SoundBoss musica_nivel2;
    private static SoundBoss sound_boing;
    private static SoundBoss sound_wildEep;
    
    //elements
    private static Entity elementoPelota;
	private static Entity elementoBase;
	private static Entity[] ladrillos = new Ladrillo[90];
	
	//Text writter  
	private static TextBoss texto;
	
	
	public Niveles(){
		fondo_nivel1 = new ImageBoss("JPG","imagenes/fondo1.jpg");
		fondo_nivel2 = new ImageBoss("JPG","imagenes/fondo2.jpg");
		colchon = new ImageBoss("PNG","imagenes/colchon.png");
		pelota = new ImageBoss("PNG","imagenes/pelota.png");
		vida_1 = new ImageBoss("PNG","imagenes/vida_1.png");
		vida_2 = new ImageBoss("PNG","imagenes/vida_2.png");
		vida_3 = new ImageBoss("PNG","imagenes/vida_3.png");
		vida_4 = new ImageBoss("PNG","imagenes/vida_4.png");
		vida_completa = new ImageBoss("PNG","imagenes/vida_completa.png");
		ladrillo_destruido = new ImageBoss("PNG","imagenes/ladrillo_destruido.png");
		ladrillo_master = new ImageBoss("PNG","imagenes/ladrillo_master.png");
		ladrillo_nivel2_destruido1 = new ImageBoss("PNG","imagenes/ladrillo_nivel2_destruido1.png");
		ladrillo_nivel2_destruido2 = new ImageBoss("PNG","imagenes/ladrillo_nivel2_destruido2.png");
		ladrillo_troll = new ImageBoss("PNG","imagenes/ladrillo-troll.png");
		ladrillo_troll1 = new ImageBoss("PNG","imagenes/ladrillo-troll1.png");
		ladrillo_troll2 = new ImageBoss("PNG","imagenes/ladrillo-troll2.png");
		ladrillo_troll3 = new ImageBoss("PNG","imagenes/ladrillo-troll3.png");
		ladrillo_troll4 = new ImageBoss("PNG","imagenes/ladrillo-troll4.png");
		ladrillo = new ImageBoss("PNG","imagenes/ladrillo.png");
		musica_nivel1 = new SoundBoss("WAV","musica/nivel1.wav");
		musica_nivel2 = new SoundBoss("WAV","musica/nivel2.wav");
	    sound_boing = new SoundBoss("WAV","musica/Boing.wav");
	    sound_wildEep = new SoundBoss("WAV", "musica/WildEep.wav");
	    texto = new TextBoss();
	    
	    elementoPelota = new Pelota(pelota.getWidth(),pelota.getHeight()); 
	    elementoBase = new Base(colchon.getWidth(),colchon.getHeight());
	    
	    for(int i=0; i < ladrillos.length; i++){
	    	ladrillos[i] = new Ladrillo(ladrillo.getWidth(),ladrillo.getHeight());
	    }
	} 
 
	public boolean playLevel1(){
		goToMenu = false;
		int maxVel = 6;
		int minVel = 2;
		prepararNivel1();
		((Pelota)elementoPelota).setVidas(4);
        ladrillosDestruidos = 90; //90
		while(!goToMenu && ((Pelota)elementoPelota).getVidas() != 0 && !(ladrillosDestruidos <= 0)){
			elementoPelota.setDX(0f);
			elementoPelota.setDY(-4f);
			elementoPelota.setX(389);
			elementoPelota.setY(464);
			elementoBase.setX(324);
			elementoBase.setY(Display.getHeight()-colchon.getHeight());
			goToMenu = false;
			musica_nivel1.playSound(SoundBoss.PLAY_AS_MUSIC);
			while(!Keyboard.isKeyDown(Keyboard.KEY_M)){
				fondo_nivel1.print(0,0);
				VidasDisplay();
				ImprimirLadrillos();
				texto.render("Presione espacio para empezar", 200, 250);
				texto.render("m para ir al menu", 220, 280);
				if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
					Play.pause(150);
					break;
				}
				checkDispExit();
				Display.update();
				Display.sync(20);
			}
			while (true) {
				if(ladrillosDestruidos <= 0 ){
					break;
				}
				if(Keyboard.isKeyDown(Keyboard.KEY_M)){
					goToMenu = true;
					break;
				}
				checkDispExit();
				
				if(((Pelota)elementoPelota).perdio()){			
					texto.render("Oportunidad Perdida", 10, 220);
					Display.update();
					Play.pause(2000);
					break;
				}
				
				fondo_nivel1.print(0,0);
				VidasDisplay();
				ImprimirLadrillos();
				pelota.print(elementoPelota.getX(), elementoPelota.getY());
				colchon.print(elementoBase.getX(), elementoBase.getY());
				((Pelota) elementoPelota).choquePelotaLados();
				if (((Pelota) elementoPelota).ChoquePelotaBase(
						elementoBase.getX(), elementoBase.getY(),
						elementoBase.width, elementoBase.heigth)) {
					sound_boing.playSound(SoundBoss.PLAY_AS_SOUND);
					if(((Base)elementoBase).ismoving()){
						if(elementoPelota.getDX() > 0 && ((Base)elementoBase).movDer()){
							elementoPelota.setDX(elementoPelota.getDX() + elementoBase.getDX()-1);
						}else if(elementoPelota.getDX() > 0 && !((Base)elementoBase).movDer()){ 
							elementoPelota.setDX(elementoPelota.getDX() - elementoBase.getDX()+1);
						}else if(elementoPelota.getDX() < 0 && ((Base)elementoBase).movDer()){
							//pelota hacia izquierda base hacia derecha
							elementoPelota.setDX(elementoPelota.getDX() + elementoBase.getDX()-1);
						}else if(elementoPelota.getDX() < 0 && !((Base)elementoBase).movDer()){
							elementoPelota.setDX(elementoPelota.getDX() - elementoBase.getDX()+1);
						}else if(elementoPelota.getDX() == 0 && ((Base)elementoBase).movDer()){
							elementoPelota.setDX(elementoBase.getDX()-0.5f);
						}else if(elementoPelota.getDX() == 0 && !((Base)elementoBase).movDer()){
							elementoPelota.setDX(-elementoBase.getDX()+0.5f);
						}
					}
					
				}
				for (int i = 0; i < ladrillos.length; i++) {
					if (((Ladrillo) ladrillos[i]).getVidas() != 0) {
						if (((Pelota) elementoPelota).chocoPelotaLadrillo(
								ladrillos[i].getX(), ladrillos[i].getY())) {
							sound_wildEep.playSound(SoundBoss.PLAY_AS_SOUND);
							((Ladrillo) ladrillos[i])
									.setVidas(((Ladrillo) ladrillos[i])
											.getVidas() - 1);
							if(((Ladrillo) ladrillos[i])
									.getVidas() == 0){
								ladrillosDestruidos --;
							}
							break;
						}
					}
				}
				float velocidad = elementoPelota.getDX();
				if(velocidad > 0){
					if(velocidad < minVel){
					elementoPelota.setDX(minVel);
					}else if(velocidad > maxVel){
						elementoPelota.setDX(maxVel);
					}
				}else if(velocidad < 0){
					if(velocidad > -minVel){
					elementoPelota.setDX(-minVel);
					}else if(velocidad < -maxVel){
						elementoPelota.setDX(-maxVel);
					}
				}
				((Pelota) elementoPelota).mover();
				((Base) elementoBase).mover();
				Display.update();
				Display.sync(100);
				
				if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
					texto.render("Pause", 200, 250);
					Display.update();
					Play.pause(250);
					while(true){
						Play.pause(20);
						checkDispExit();
						if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
							Play.pause(100);
							break;
						}
					}
				}
						
		}
		}

		if(ladrillosDestruidos <= 0){
			return true; 
		}
		else {
			return false;
		}
	}
	
	private void prepararNivel1(){
		

		//asigno Posiciones __ placing brikcs
		int contador = 0;
		for(int i=0;i<6;i++){
		      for( int j=0;j<15;j++){
		        ladrillos[contador].setX((j*ladrillo.getWidth())+60);
		        ladrillos[contador].setY((i*ladrillo.getHeight())+70);
		        contador ++;
		      }
		   }
		
		//asigno tipo de ladrillos  __ assigning types of bricks
		for(int i=0;i<90;i++){
			   ((Ladrillo) ladrillos[i]).setVidas(2); //Este numero representara la vida de el cubito;
			   ((Ladrillo) ladrillos[i]).setTipo(1); 
			}

			for(int i=0;i<90; i += 15 ){
			   ((Ladrillo) ladrillos[i]).setVidas(3);
			   ((Ladrillo) ladrillos[i]).setTipo(2);
			}

			for(int i=0; i<15; i++){
				((Ladrillo) ladrillos[i]).setVidas(3);
				((Ladrillo) ladrillos[i]).setTipo(2);
			}

			for(int i=75;i<90;i++){
				((Ladrillo) ladrillos[i]).setVidas(3);
				((Ladrillo) ladrillos[i]).setTipo(2);
			}

			for(int i=14;i<90;i+=15){
				((Ladrillo) ladrillos[i]).setVidas(3);
				((Ladrillo) ladrillos[i]).setTipo(2);
			}

	}
	
	
	public boolean playLevel2(){
		int maxVel = 7;
		int minVel = 4;
		goToMenu = false;
		prepararNivel2();
		((Pelota)elementoPelota).setVidas(4);
        ladrillosDestruidos = 67;//67
		while(!goToMenu && ((Pelota)elementoPelota).getVidas() != 0 && !(ladrillosDestruidos <= 0)){
			elementoPelota.setDX(0);
			elementoPelota.setDY(-3);
			elementoPelota.setX(389);
			elementoPelota.setY(464);
			elementoBase.setX(324);
			elementoBase.setY(Display.getHeight()-colchon.getHeight());
			goToMenu = false;
			musica_nivel2.playSound(SoundBoss.PLAY_AS_MUSIC);
			while(!Keyboard.isKeyDown(Keyboard.KEY_M)){
				fondo_nivel2.print(0,0);
				VidasDisplay();
				ImprimirLadrillos();
				texto.render("Presione espacio para empezar", 200, 250);
				texto.render("m para ir al menu", 220, 280);
				if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
					Play.pause(150);
					break;
				}
				checkDispExit();
				Display.update();
				Display.sync(20);
			}
			while (true) {
				if(ladrillosDestruidos <= 0 ){
					break;
				}
				if(Keyboard.isKeyDown(Keyboard.KEY_M)){
					goToMenu = true;
					break;
				}
				
				checkDispExit();
				
				if(((Pelota)elementoPelota).perdio()){			
					texto.render("Oportunidad Perdida", 10, 220);
					Display.update();
					Play.pause(2000);
					break;
				}
				
				fondo_nivel2.print(0,0);
				VidasDisplay();
				ImprimirLadrillos();
				pelota.print(elementoPelota.getX(), elementoPelota.getY());
				colchon.print(elementoBase.getX(), elementoBase.getY());
				((Pelota) elementoPelota).choquePelotaLados();
				if (((Pelota) elementoPelota).ChoquePelotaBase(
						elementoBase.getX(), elementoBase.getY(),
						elementoBase.width, elementoBase.heigth)) {
					sound_boing.playSound(SoundBoss.PLAY_AS_SOUND);
					if(((Base)elementoBase).ismoving()){
						if(elementoPelota.getDX() > 0 && ((Base)elementoBase).movDer()){
							elementoPelota.setDX(elementoPelota.getDX() + elementoBase.getDX());
						}else if(elementoPelota.getDX() > 0 && !((Base)elementoBase).movDer()){ 
							elementoPelota.setDX(elementoPelota.getDX() - elementoBase.getDX());
						}else if(elementoPelota.getDX() < 0 && ((Base)elementoBase).movDer()){
							//pelota hacia izquierda base hacia derecha
							elementoPelota.setDX(elementoPelota.getDX() + elementoBase.getDX());
						}else if(elementoPelota.getDX() < 0 && !((Base)elementoBase).movDer()){
							elementoPelota.setDX(elementoPelota.getDX() - elementoBase.getDX());
						}else if(elementoPelota.getDX() == 0 && ((Base)elementoBase).movDer()){
							elementoPelota.setDX(elementoBase.getDX()-0.5f);
						}else if(elementoPelota.getDX() == 0 && !((Base)elementoBase).movDer()){
							elementoPelota.setDX(-elementoBase.getDX()+0.5f);
						}
					}
				}
				for (int i = 0; i < ladrillos.length; i++) {
					if (((Ladrillo) ladrillos[i]).getVidas() != 0) {
						if (((Pelota) elementoPelota).chocoPelotaLadrillo(
								ladrillos[i].getX(), ladrillos[i].getY())) {
							sound_wildEep.playSound(SoundBoss.PLAY_AS_SOUND);
							((Ladrillo) ladrillos[i])
									.setVidas(((Ladrillo) ladrillos[i])
											.getVidas() - 1);
							if(((Ladrillo) ladrillos[i])
									.getVidas() == 0){
								ladrillosDestruidos --;
							}
							break;
						}
					}
				}
				float velocidad = elementoPelota.getDX();
				if(velocidad > 0){
					if(velocidad < minVel){
					elementoPelota.setDX(minVel);
					}else if(velocidad > maxVel){
						elementoPelota.setDX(maxVel);
					}
				}else if(velocidad < 0){
					if(velocidad > -minVel){
					elementoPelota.setDX(-minVel);
					}else if(velocidad < -maxVel){
						elementoPelota.setDX(-maxVel);
					}
				}
				((Pelota) elementoPelota).mover();
				((Base) elementoBase).mover();
				Display.update();
				Display.sync(100);
				
				if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
					texto.render("Pause", 200, 250);
					Display.update();
					Play.pause(250);
					while(true){
						Play.pause(20);
						checkDispExit();
						if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
							Play.pause(100);
							break;
						}
					}
				}
						
		}
		}

		if(ladrillosDestruidos <= 0){
			return true; 
		}
		else {
			return false;
		}
	}
	
	private void prepararNivel2(){
		

		//asigno Posiciones
		int contador = 0;
		for(int i=0;i<6;i++){
		      for( int j=0;j<15;j++){
		        ladrillos[contador].setX((j*(ladrillo.getWidth()+10))+20);
		        ladrillos[contador].setY((i*(ladrillo.getHeight()+3))+70);
		        contador ++;
		      }
		   }
		
		//asigno tipo de ladrillos
		for(int i=0;i<90;i++){
			   ((Ladrillo) ladrillos[i]).setVidas(3); //Este numero representara la vida de el cubito;
			   ((Ladrillo) ladrillos[i]).setTipo(2); 
			}
		
		for(int i=0; i<90; i += 2 ){
			   ((Ladrillo) ladrillos[i]).setVidas(5);
			   ((Ladrillo) ladrillos[i]).setTipo(3);
			}

			for(int i=0;i<90; i += 15 ){
			   ((Ladrillo) ladrillos[i]).setVidas(5);
			   ((Ladrillo) ladrillos[i]).setTipo(3);
			}

			for(int i=75; i<90; i++){
				((Ladrillo) ladrillos[i]).setVidas(5);
				((Ladrillo) ladrillos[i]).setTipo(3);
			}

			for(int i=14;i<90;i+= 15){
				((Ladrillo) ladrillos[i]).setVidas(5);
				((Ladrillo) ladrillos[i]).setTipo(3);
			}

			for(int i=0;i<90;i+=4){
				((Ladrillo) ladrillos[i]).setVidas(0);
			}

	}
	
	private void ImprimirLadrillos(){
		
		//ladrillo normal __ normal brick 
		for(Entity ladrillaso: ladrillos){
			if (((Ladrillo) ladrillaso).getVidas() != 0) {
				
				if (((Ladrillo) ladrillaso).getTipo() == 1) {
					if (((Ladrillo) ladrillaso).getVidas() == 2) {
						ladrillo.print(ladrillaso.getX(), ladrillaso.getY());
					}
					if (((Ladrillo) ladrillaso).getVidas() == 1) {
						ladrillo_destruido.print(ladrillaso.getX(),
								ladrillaso.getY());
					}
				}
				
				//ladrillo con cosa negra __ ninja brick
				if (((Ladrillo) ladrillaso).getTipo() == 2) {
					if (((Ladrillo) ladrillaso).getVidas() == 3) {
						ladrillo_master.print(ladrillaso.getX(),
								ladrillaso.getY());
					}
					if (((Ladrillo) ladrillaso).getVidas() == 2) {
						ladrillo_nivel2_destruido1.print(ladrillaso.getX(),
								ladrillaso.getY());
					}
					if (((Ladrillo) ladrillaso).getVidas() == 1) {
						ladrillo_nivel2_destruido2.print(ladrillaso.getX(),
								ladrillaso.getY());
					}
				}
				
			  //ladrillo verde __ green brick
				if (((Ladrillo) ladrillaso).getTipo() == 3) {
					if (((Ladrillo) ladrillaso).getVidas() == 5) {
						ladrillo_troll.print(ladrillaso.getX(),
								ladrillaso.getY());
					}
					if (((Ladrillo) ladrillaso).getVidas() == 4) {
						ladrillo_troll1.print(ladrillaso.getX(),
								ladrillaso.getY());
					}
					if (((Ladrillo) ladrillaso).getVidas() == 3) {
						ladrillo_troll2.print(ladrillaso.getX(),
								ladrillaso.getY());
					}
					if (((Ladrillo) ladrillaso).getVidas() == 2) {
						ladrillo_troll3.print(ladrillaso.getX(),
								ladrillaso.getY());
					}
					if (((Ladrillo) ladrillaso).getVidas() == 1) {
						ladrillo_troll4.print(ladrillaso.getX(),
								ladrillaso.getY());
					}
				}
				
				
				
			}
		}
	}
	
	
	//prints remaining lives
	private void VidasDisplay(){
		switch (((Pelota)elementoPelota).getVidas()){
		case 0:
			goToMenu = true;
			vida_4.print(2, 8);
			break;
		case 1:
			vida_3.print(2, 8);
		    break;
		case 2:
			vida_2.print(2, 8);
			break;
		case 3:
			vida_1.print(2, 8);
			break;
		case 4:
			vida_completa.print(2, 8);
			break;
		
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
