
package stratego;

import java.io.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.*;
import javax.sound.sampled.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;

public class Stratego extends JFrame implements Runnable {
    boolean animateFirstTime = true;
    Image image;
    Graphics2D g;

    Image background;
    private static boolean deployPhase = true;
    private static int count = 0;
    public static void main(String[] args) {
        Stratego frame = new Stratego();
        frame.setSize(Window.WINDOW_WIDTH, Window.WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        System.out.println("Welcome to Stratego!");
        System.out.println("This is the deployment phase, where you will arrange your pieces on your side of the board.");
        System.out.println("=======================================");
        Commands.AvailablePieces();
        System.out.println("Left-click anywhere on your side of the board to place a piece.");
        System.out.println("Enter Deployment Phase Commands by pressing space first");
        System.out.println("Waiting on opponent...");

    }

    public Stratego() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {

                if (e.BUTTON1 == e.getButton() ) {
                    
                if(deployPhase && Board.testSpot(e.getX(),e.getY())){
                    Board.AddPiecePixel(e.getX(),e.getY());
                    count++;
<<<<<<< Updated upstream
                    if(count ==1){
                        deployPhase = false;                        
                        System.out.println("=======================================");
                        System.out.println("We are now entering the battle phase");
                        System.out.println("The goal here is to capture the enemy's flag or eliminate all mobile enemies.");        
                        System.out.println("Enter Battle Phase Commands by pressing space first:");
                    }
=======
                    if(count ==5)
                        deployPhase = false;
>>>>>>> Stashed changes
                }
                else if(!deployPhase){
                    Board.selectPiece(e.getX(),e.getY());
                    }
                }

                if (e.BUTTON3 == e.getButton()) {

                }
                repaint();
            }
        });    
    


    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {

        repaint();
      }
    });

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseMoved(MouseEvent e) {

        repaint();
      }
    });

        addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {
                if (e.VK_UP == e.getKeyCode()) {
                    if(Board.selected)
                    Board.movePiece(3);
                } else if (e.VK_DOWN == e.getKeyCode()) {
                    if(Board.selected)
                    Board.movePiece(4);
                } else if (e.VK_LEFT == e.getKeyCode()) {
                    if(Board.selected)
                    Board.movePiece(-1);
                } else if (e.VK_RIGHT == e.getKeyCode()) {
                    if(Board.selected)
                    Board.movePiece(1);
                } else if (e.VK_ESCAPE == e.getKeyCode()) {
                    reset();
                } else if (e.VK_SPACE == e.getKeyCode()) {
                    Commands.readCommand();
                }
                repaint();
            }
        });
        init();
        start();
    }
    Thread relaxer;
////////////////////////////////////////////////////////////////////////////
    public void init() {
        requestFocus();
    }
////////////////////////////////////////////////////////////////////////////
    public void destroy() {
    }
////////////////////////////////////////////////////////////////////////////
    public void paint(Graphics gOld) {
        if (image == null || Window.xsize != getSize().width || Window.ysize != getSize().height) {
            Window.xsize = getSize().width;
            Window.ysize = getSize().height;
            image = createImage(Window.xsize, Window.ysize);
            g = (Graphics2D) image.getGraphics();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
        }
//fill background
        
        g.setColor(Color.MAGENTA);
        g.fillRect(0, 0, Window.xsize, Window.ysize);

        int x[] = {Window.getX(0), Window.getX(Window.getWidth2()), Window.getX(Window.getWidth2()), Window.getX(0), Window.getX(0)};
        int y[] = {Window.getY(0), Window.getY(0), Window.getY(Window.getHeight2()), Window.getY(Window.getHeight2()), Window.getY(0)};
//fill border
        g.setColor(Color.white);
        g.fillPolygon(x, y, 4);
// draw border
        g.setColor(Color.GRAY);
        g.drawPolyline(x, y, 5);

        if (animateFirstTime) {
            gOld.drawImage(image, 0, 0, null);
            return;
        }
        
        g.drawImage(background,Window.getX(0),Window.getY(0),
            Window.getWidth2(),Window.getHeight2(),this);
              
        Board.Draw(g);

        gOld.drawImage(image, 0, 0, null);
    }
    
////////////////////////////////////////////////////////////////////////////
// needed for     implement runnable
    public void run() {
        while (true) {
            animate();
            repaint();
            double seconds = .1;    //time that 1 frame takes.
            int miliseconds = (int) (1000.0 * seconds);
            try {
                Thread.sleep(miliseconds);
            } catch (InterruptedException e) {
            }
        }
    }
    
/////////////////////////////////////////////////////////////////////////
    public void reset() {
        Board.Reset();
        deployPhase = true;
        count = 0;
    }
/////////////////////////////////////////////////////////////////////////
    public void animate() {

        if (animateFirstTime) {
            animateFirstTime = false;
            if (Window.xsize != getSize().width || Window.ysize != getSize().height) {
                Window.xsize = getSize().width;
                Window.ysize = getSize().height;
            }
            background = Toolkit.getDefaultToolkit().getImage("./background.png");
            reset();

        }
    }

////////////////////////////////////////////////////////////////////////////
    public void start() {
        if (relaxer == null) {
            relaxer = new Thread(this);
            relaxer.start();
        }
    }
////////////////////////////////////////////////////////////////////////////
    public void stop() {
        if (relaxer.isAlive()) {
            relaxer.stop();
        }
        relaxer = null;
    }    
    public static void decreaseCount(){
    count--;
}
    
    
}
