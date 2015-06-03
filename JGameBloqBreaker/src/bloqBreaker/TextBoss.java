package bloqBreaker;

import java.awt.Font;
import java.io.InputStream;

import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;


public class TextBoss {
	TrueTypeFont font;
	

	public TextBoss(){
			
		// load font from a .ttf file
		try {
			InputStream inputStream	= ResourceLoader.getResourceAsStream("fuentes/fuente1.ttf");
			
			Font awtFont2 = Font.createFont(Font.TRUETYPE_FONT, inputStream);
			awtFont2 = awtFont2.deriveFont(30f); // set font size
			font = new TrueTypeFont(awtFont2, false);
				
		} catch (Exception e) {
			e.printStackTrace();
		}	

	}
		public void render(String string, int x, int y) {
			Color.white.bind();
			font.drawString(x, y, string, Color.white);
		}
		

}

