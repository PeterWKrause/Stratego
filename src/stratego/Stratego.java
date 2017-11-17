
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
    private static boolean deployPhase = false;
    public static boolean start = true;
    private static int count = 0;
    Image startScreen = Toolkit.getDefaultToolkit().getImage("./StartScreen.png");
    public static boolean redDeploy = false;
    public static boolean blueDeploy = false;
    public static int timeCount = 0;
    public static void main(String[] args) {
        Stratego frame = new Stratego();
        frame.setSize(Window.WINDOW_WIDTH, Window.WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        frame.setTitle("Stratego");
        frame.setAlwaysOnTop(true);
        
        System.out.println("Welcome to Stratego!");
        

    }

    public Stratego() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {

                if (e.BUTTON1 == e.getButton() ) {
                    if(redDeploy || blueDeploy)
                        return;
                  if(start){
                      if(e.getX()<Window.getWidth2()/2+100&&e.getX()>Window.getWidth2()/2-30&&
                           e.getY()<Window.getHeight2()/2+300 &&e.getY()>Window.getHeight2()/2+250){
                        start = false;
                      deployPhase = true;
                      redDeploy = true;
                      System.out.println("This is the deployment phase, where you will arrange your pieces on your side of the board.");
        System.out.println("=======================================");
        Commands.AvailablePieces();
        Commands.WhatIsBomb();
        Commands.WhatIsFlag();
        Commands.WhatIsSpy();
        Commands.WhatIsScout();
        Commands.WhatIsMiner();
        Commands.WhatIsSergeant();
        Commands.WhatIsLieutenant();
        Commands.WhatIsCaptain();
        Commands.WhatIsMajor();
        Commands.WhatIsColonel();
        Commands.WhatIsGeneral();
        Commands.WhatIsMarshall();
        System.out.println("Left-click anywhere on your side of the board to place a piece. When prompted, enter a piece's rank into the output.");
        return;
                      }
                    }
                    
                if(deployPhase && Board.testSpot(e.getX(),e.getY())){
                    Board.AddPiecePixel(e.getX(),e.getY());
                    count++;

<<<<<<< Updated upstream
                    if(count ==2){
                          Board.turn = true;
                          System.out.println("Waiting on opponent...");
                    }
                    if(count ==4){
                        Board.TurnCount++;
=======

                    if(count ==1){
                          blueDeploy=true;
                          Board.turn = !Board.turn;
                          System.out.println("Waiting on opponent...");
                    }
                    if(count ==2){
                        Board.blackBox=true;
>>>>>>> Stashed changes
                        deployPhase = false;
                        System.out.println("=======================================");
                        System.out.println("We are now entering the battle phase");
                        System.out.println("The goal here is to capture the enemy's flag or eliminate all mobile enemies.");
                    }

                    
                    
//                        if(count ==3){
//                        Board.TurnCount++;
//                        deployPhase = false;
//                        Board.turn = false;
//
//                        System.out.println("=======================================");
//                        System.out.println("We are now entering the battle phase");
//                        System.out.println("The goal here is to capture the enemy's flag or eliminate all mobile enemies.");        
//                        System.out.println("Enter Battle Phase Commands by pressing space first:");
//                    }






                }
                else if(!deployPhase){
                    Board.selectPiece(e.getX(),e.getY());
                    }
                }

                if (e.BUTTON3 == e.getButton()) {
                    
                    if(redDeploy){
                        redDeploy=false;
                    }
                    if(blueDeploy){
                        blueDeploy = false;
                        Board.turn=!Board.turn;
                        Board.blackBox = true;
                    }
                    if(Board.blackBox){
                        Board.blackBox = false;
                        Board.turnDone=false;
                        Board.TurnCount++;
                        Board.turn=!Board.turn;
                    }
                    if(!Board.blackBox && !redDeploy && !blueDeploy){
                        Board.blackBox = true;
                        
                        
                    }
                    
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
                if(start)
                    return;
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
        Color name = new Color(242,239,113);
        g.setColor(name);
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
        
        if(start){
        g.drawImage(startScreen,Window.getX(0),Window.getY(0),
            Window.getWidth2(),Window.getHeight2(),this);
        Color startColor = new Color(84,22,180);
        g.setColor(startColor);
        g.fillRect(Window.getWidth2()/2-30,Window.getHeight2()/2+250,130,50);
        Color wordColor = new Color(255,223,0);
            g.setColor(wordColor);
            g.setFont(new Font("ALGERIAN",Font.ITALIC,21));
            g.drawString("Challenge",Window.getWidth2()/2-25,Window.getHeight2()/2+282); 
        }
        if(redDeploy){
            g.setColor(Color.black);
            g.fillRect(-5, -5, 5000, 5000);
            g.setColor(Color.yellow);
            g.setFont(new Font("Britannic Bold",Font.ITALIC,50));
            g.drawString("Red will now deploy",Window.getWidth2()/2-225,Window.getHeight2()/2); 
            g.drawString("Blue player turn around",Window.getWidth2()/2-225,Window.getHeight2()/2+80); 
            g.drawString("Right click when ready",Window.getWidth2()/2-225,Window.getHeight2()/2+280);
        }
        if(blueDeploy){
            g.setColor(Color.black);
            g.fillRect(-5, -5, 5000, 5000);
            g.setColor(Color.yellow);
            g.setFont(new Font("Britannic Bold",Font.ITALIC,50));
            g.drawString("Blue will now deploy",Window.getWidth2()/2-225,Window.getHeight2()/2); 
            g.drawString("Red player turn around",Window.getWidth2()/2-225,Window.getHeight2()/2+80); 
            g.drawString("Right click when ready",Window.getWidth2()/2-225,Window.getHeight2()/2+280);
        }
        if(!blueDeploy && !redDeploy)    
        Board.Draw(g);
        
        if(Board.blackBox && Board.turnDone ==true && Board.turn){
            g.setColor(Color.black);
            g.fillRect(-5, -5, 5000, 5000);
            g.setColor(Color.yellow);
            g.setFont(new Font("Britannic Bold",Font.ITALIC,50));
            g.drawString("Red's turn",Window.getWidth2()/2-225,Window.getHeight2()/2); 
            g.drawString("Blue player turn around",Window.getWidth2()/2-225,Window.getHeight2()/2+80); 
            g.drawString("Right click when ready",Window.getWidth2()/2-225,Window.getHeight2()/2+280);
        }
        if(Board.blackBox && Board.turnDone == true && !Board.turn){
            g.setColor(Color.black);
            g.fillRect(-5, -5, 5000, 5000);
            g.setColor(Color.yellow);
            g.setFont(new Font("Britannic Bold",Font.ITALIC,50));
            g.drawString("Blue's turn",Window.getWidth2()/2-225,Window.getHeight2()/2); 
            g.drawString("Red player turn around",Window.getWidth2()/2-225,Window.getHeight2()/2+80); 
            g.drawString("Right click when ready",Window.getWidth2()/2-225,Window.getHeight2()/2+280);
        }
        Piece.setObj(this);
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
        deployPhase = false;
        start = true;
        count = 0;
        redDeploy = false;
        blueDeploy = false;
        timeCount = 0;
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
            
            
            timeCount++;
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
    
   
