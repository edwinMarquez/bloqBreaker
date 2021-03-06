package bloqBreaker;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2f;
import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class ImageBoss {
	
	//loading the image...
	private Texture texture;
	//to know the dimensions
	private int width;
	private int height;
	
	public ImageBoss( String format, String location){
		
		try {
			texture = TextureLoader.getTexture(format, ResourceLoader.getResourceAsStream(location));
			width = texture.getImageWidth();
			height = texture.getImageHeight();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public int  getWidth(){
		return width;
	}
	
    public int getHeight(){
    	return  height;
    }
    
    public void print(int x, int y ){
	
		
		// store the current model matrix
		glPushMatrix();

		// bind to the appropriate texture for this sprite
		texture.bind();

		// translate to the right location and prepare to draw
		glTranslatef(x, y, 0);

		// draw a quad textured to match the sprite
		glBegin(GL_QUADS);
		{
			glTexCoord2f(0, 0);
			glVertex2f(0, 0);

			glTexCoord2f(0, texture.getHeight());
			glVertex2f(0, height);

			glTexCoord2f(texture.getWidth(), texture.getHeight());
			glVertex2f(width, height);

			glTexCoord2f(texture.getWidth(), 0);
			glVertex2f(width, 0);
		}
		glEnd();

		// restore the model view matrix to prevent contamination
		glPopMatrix();
	
		
    	
    }
    
    
}
