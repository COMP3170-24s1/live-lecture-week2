import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL15.GL_ELEMENT_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.GL_UNSIGNED_INT;
import static org.lwjgl.opengl.GL11.glDrawArrays;
import static org.lwjgl.opengl.GL15.glBindBuffer;
import static org.lwjgl.opengl.GL15.glDrawElements;

import org.joml.Vector3f;
import org.joml.Vector4f;

import comp3170.GLBuffers;
import comp3170.Shader;
import comp3170.ShaderLibrary;

public class Scene {
	
	final private String VERTEX_SHADER = "vertex.glsl";
	final private String FRAGMENT_SHADER = "fragment.glsl";
	
	private Vector4f[] vertices;
	private int vertexBuffer;
	private int[] indices;
	private int indexBuffer;
	private Shader shader;
	private int screenWidth;
	private int screenHeight;
	
	public Scene(int width, int height) {
		
		screenWidth = width;
		screenHeight = height;
		
		// compile the shader
		shader = ShaderLibrary.instance.compileShader(VERTEX_SHADER,  FRAGMENT_SHADER);
		
		// vertices of a triangle as (x,y) pairs
		// @formatter:off
		
		vertices = new Vector4f[] {
				
				// Bottom triangle
				new Vector4f( 0.8f,  -0.8f, 0.0f, 1.0f), // Bottom right - C
				new Vector4f(-0.8f,  -0.8f, 0.0f, 1.0f), // Bottom left - D
				new Vector4f(-0.8f,   0.8f, 0.0f, 1.0f), // Top left - A
				new Vector4f( 0.8f,   0.8f, 0.0f, 1.0f) // Top right - B
				
		};
		
		// @formatter:on
		
		vertexBuffer = GLBuffers.createBuffer(vertices);
		
		// Define indices
		
		indices = new int[] {
				0, 1, 2,
				0, 2, 3
		};
		
		indexBuffer = GLBuffers.createIndexBuffer(indices);
		
	}
	
	public void draw() {
		// activate the shader
		shader.enable();
		
		// connect the vertex buffer to the a_position attribute
		shader.setAttribute("a_position", vertexBuffer);
		
		// bind the buffer
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, indexBuffer);
		
		// write the colour value into the u_colour uniform
		Vector3f colour = new Vector3f(0.0f, 0.75f, 0.50f); // Crystal blue
		shader.setUniform("u_colour", colour);
		
		// draw the shape
		glDrawElements(GL_TRIANGLES, indices.length, GL_UNSIGNED_INT, 0);
	}
		

}
