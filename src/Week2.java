import static org.lwjgl.opengl.GL15.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL15.glClear;
import static org.lwjgl.opengl.GL15.glClearColor;
import static org.lwjgl.opengl.GL15.glViewport;

import java.io.File;
import java.io.IOException;

import comp3170.IWindowListener;
import comp3170.OpenGLException;
import comp3170.ShaderLibrary;
import comp3170.Window;

public class Week2 implements IWindowListener {
	
	private int screenWidth = 800;
	private int screenHeight = 800;
	
	private Scene scene;
	
	final private File DIRECTORY = new File("src/");
	
	public Week2() throws OpenGLException {
		// create window with title, size, and a listener (this)
		Window window = new Window("Hello COMP3170!", screenWidth, screenHeight, this);
		
		// start running the window
		window.run();
	}
	
	public static void main(String[] args) throws OpenGLException {
		new Week2();
	}

	@Override
	public void init() {
		
		new ShaderLibrary(DIRECTORY);
		
		scene = new Scene(screenWidth, screenHeight);
		
		glClearColor(0.25f,0.25f,0.25f,1.0f); // RGBA
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw() {
		glClear(GL_COLOR_BUFFER_BIT);
		
		scene.draw();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
