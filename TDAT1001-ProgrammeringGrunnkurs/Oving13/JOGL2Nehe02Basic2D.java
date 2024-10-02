
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.gl2.GLUT;
import com.sun.corba.se.spi.orbutil.fsm.Guard;

// import MulticolorCubeWithKeyboardListener.RotateKeyListener;


/**
 * NeHe Lesson #2 (JOGL 2 Port): Basic 2D Shapes
 * @author Tomas Holt, based on code from Hock-Chuan Chua (May 2012)
 * @version October 2016
 */

/* Main class which extends GLCanvas. This means that this is a OpenGL canvas.
   We will use OpenGL commands to draw on this canvas.
   This implementation has no animation or user input.
*/
public class JOGL2Nehe02Basic2D extends GLCanvas implements GLEventListener {
   // constants
   private static String TITLE = "Nehe #2: Your First 2D Polygon";
   private static final int CANVAS_WIDTH = 600;  // width of the drawable
   private static final int CANVAS_HEIGHT = 600; // height of the drawable
  
   // Setup OpenGL Graphics Renderer 
   private GLU glu;// for the GL Utility
   private int rotAngle;
   
   /** Constructor to setup the GUI for this Component */
   public JOGL2Nehe02Basic2D() {
      this.addGLEventListener(this);
      this.addKeyListener(new RotateKeyListener()); //listener for keyboard
   }
   
// ------ Implement methods declared in GLEventListener (init,reshape,display,dispose)          

   /**
    * Called immediately after the OpenGL context is initialized. Can be used 
    * to perform one-time initialization. Run only once.
    */
   public void init(GLAutoDrawable drawable) {
      GL2 gl = drawable.getGL().getGL2();      // get the OpenGL graphics context
      glu = new GLU();                         // get GL Utilities
      gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f); // set background (clear) color
      gl.glEnable(GL2.GL_DEPTH_TEST);           // enables depth testing
      gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST); // best perspective correction
   }

   /**
    * Handler for window re-size event. Also called when the drawable is 
    * first set to visible
    */
   public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
      GL2 gl = drawable.getGL().getGL2();  // get the OpenGL 2 graphics context

      if (height == 0) height = 1;   // prevent divide by zero     
      float aspect = (float)width / height;

      //Set the view port (display area) to cover the entire window
      //gl.glViewport(0, 0, width, height);

      // Setup perspective projection, with aspect ratio matches viewport
      gl.glMatrixMode(GL2.GL_PROJECTION);  // choose projection matrix
      gl.glLoadIdentity();             // reset projection matrix
      glu.gluPerspective(70.0, aspect, 0.01, 100.0); // fovy, aspect, zNear, zFar

      // Enable the model-view transform
      gl.glMatrixMode(GL2.GL_MODELVIEW);
      gl.glLoadIdentity(); // reset
   }

   
   
   
   /**
    * Called by OpenGL for drawing
    */
   public void display(GLAutoDrawable drawable) {
      GL2 gl = drawable.getGL().getGL2();  // get the OpenGL 2 graphics context
      gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT); // clear color and depth buffers
      gl.glLoadIdentity();  // reset the model-view matrix

      
      
      // Oppgave 1
      
      double[][] tabell = {{0.0, 2.0, 0.0}, {1.5, 1.5, 0.0}, {2.0, 0.0, 0.0}, {1.5, -1.5, 0.0}, {0.0, -2.0, 0.0}, {-1.5, -1.5, 0.0}, {-2.0, 0.0, 0.0}, {-1.5, 1.5, 0.0}};
      
      gl.glTranslatef(-1.5f, 0.0f, -10.0f);
      gl.glBegin(GL2.GL_LINE_LOOP);
      	for (int i = 0; i < 8; i++) {
      		gl.glVertex3dv(tabell[i], 0);
      	}
      gl.glEnd();
      

      // Oppgave 2
      // a
      double[][] tabell1 = {{-1.0, -1.0, 1.0}, {1.0, -1.0, 1.0}, {1.0, 1.0, 1.0}, {-1.0, 1.0, 1.0}};
      double[][] tabell2 = {{-1.0, -1.0, 1.0}, {-1.0, -1.0, -1.0}, {-1.0, 1.0, -1.0}, {-1.0, 1.0, 1.0}};
      double[][] tabell3 = {{1.0, 1.0, 1.0}, {1.0, 1.0, -1.0}, {-1.0, 1.0, -1.0}, {-1.0, 1.0, 1.0}};
      double[][] tabell4 = {{1.0, -1.0, 1.0}, {1.0, -1.0, -1.0}, {1.0, 1.0, -1.0}, {1.0, 1.0, 1.0}};
      double[][] tabell5 = {{1.0, -1.0, 1.0}, {1.0, -1.0, -1.0}, {-1.0, -1.0, -1.0}, {-1.0, -1.0, 1.0}};
      double[][] tabell6 = {{1.0, -1.0, -1.0}, {1.0, 1.0, -1.0}, {-1.0, -1.0, -1.0}, {-1.0, -1.0, -1.0}};
      
      
      gl.glTranslated(0.0, 0.0, -10.0);
      gl.glRotated(rotAngle, 1, 1, 1);
      gl.glBegin(GL2.GL_LINE_LOOP);
      //Front	
      for (int i = 0; i < tabell1.length; i++) {
  		gl.glVertex3dv(tabell1[i], 0);
      }
      // Venstre
      for (int i = 0; i < tabell2.length; i++) {
      	gl.glVertex3dv(tabell2[i], 0);
      }
      // Topp
      for (int i = 0; i < tabell3.length; i++) {
      	gl.glVertex3dv(tabell3[i], 0);
      }
      // Høyre
      for (int i = 0; i < tabell4.length; i++) {
      	gl.glVertex3dv(tabell4[i], 0);
      }
      // Bunn
      for (int i = 0; i < tabell5.length; i++) {
      	gl.glVertex3dv(tabell5[i], 0);
      }
      // Bak
      for (int i = 0; i < tabell6.length; i++) {
      	gl.glVertex3dv(tabell6[i], 0);
      }
      gl.glEnd();
      
      // b
      GLUT glut = new GLUT();
      glut.glutWireCube(4);
      
      glu.gluLookAt(1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0);
      gl.glScaled(1.5, 1.5, 1.5);
      GLUT glut2 = new GLUT();
      glut2.glutWireCube(4);
      
      
      

      	


      
      
      
   }

   /** 
    * Called before the OpenGL context is destroyed. Release resource such as buffers. 
    */
   public void dispose(GLAutoDrawable drawable) { }
  
   private class RotateKeyListener extends KeyAdapter{
       public void keyPressed(KeyEvent e) {
           //accept any key    
           rotAngle += 1;//
           JOGL2Nehe02Basic2D.this.repaint();//repaint our canvas
       }
   }
    
   /** The entry main() method to setup the top-level JFrame with our OpenGL canvas inside */
   public static void main(String[] args) {
       GLCanvas canvas = new JOGL2Nehe02Basic2D();
       
       canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
       
       final JFrame frame = new JFrame(); // Swing's JFrame or AWT's Frame
       frame.getContentPane().add(canvas);
       frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//stop program
       frame.setTitle(TITLE);
       frame.pack();
       frame.setVisible(true);      
   }
}
