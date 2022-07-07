package joglTest;


import static com.jogamp.opengl.GL3.*;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.Buffer;
import java.nio.ByteBuffer;

import javax.swing.JFrame;

import com.jogamp.opengl.GL3;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.Animator;
import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.GLDrawableFactory;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLOffscreenAutoDrawable;


@SuppressWarnings("unused")
public class MainFrame extends JFrame implements GLEventListener
{
	
	private MainFrame()
	{
		GLProfile profile = GLProfile.get(GLProfile.GL3);
		GLCapabilities capabilities = new GLCapabilities(profile);

		GLOffscreenAutoDrawable canvas = GLDrawableFactory.getFactory(profile).createOffscreenAutoDrawable(null,
				capabilities, null, 500, 500);

		canvas.addGLEventListener(new GLEventListener() {
			@Override
			public void init(GLAutoDrawable drawable) {
				drawable.getContext().makeCurrent();
			}
			
			@Override
			public void display(GLAutoDrawable drawable) {
				GL3 gl = drawable.getGL().getGL3();
				gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
				gl.glClear(GL3.GL_COLOR_BUFFER_BIT);

				byte[] data = new byte[4];
				Buffer pixels = ByteBuffer.wrap(data);
				gl.glReadPixels(0, 0, 1, 1, GL3.GL_RGBA, GL3.GL_BYTE, pixels);

				System.out.println(String.format("gl color: \t%02x%02x%02x%02x", data[3], data[0], data[1], data[2]));			
			}
			
			@Override
			public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
			}
			
			@Override
			public void dispose(GLAutoDrawable drawable) {
			}
		});

		canvas.display();
		
		
	}
	
	
	double equation[] = { 1f, 1f, 1f, 1f};
	
	private static int idPoint = 0;

	private static int numVAOs = 1; 
	private static int idBuffer = 0;

	private static int numVBOs = 1; 
	private int vPosition = 0;
	private final int numVertices = 1;
	        // Declare VAOs and VBOs
	private static int[] VAOs = new int[numVAOs]; private static int[] VBOs = new int[numVBOs];


	public static void main(String[] argse) {
		// TODO Auto-generated method stub]
		new MainFrame();
		
	}


	@Override
	public void init(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void dispose(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		
		
	}


	@Override
	public void display(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		
	}
	
	private GLCanvas canvas;
	public static GLAutoDrawable drawable;
	private Animator animator;

}
