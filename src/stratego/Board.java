
package stratego;

import java.awt.*;

public class Board {
    private final static int NUM_ROWS = 10;
    private final static int NUM_COLUMNS = 10;      
    private static Piece board[][] = new Piece[NUM_ROWS][NUM_COLUMNS];

    
    public static void Draw(Graphics2D g) {
        
//Calculate the width and height of each board square.
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;
        
 //draw grid
        g.setColor(Color.black);
        for (int zi = 1;zi<NUM_ROWS;zi++)
        {
            g.drawLine(Window.getX(0),Window.getY(zi*ydelta),
                    Window.getX(Window.getWidth2()),Window.getY(zi*ydelta));
        }
        
        for (int zi = 1;zi<NUM_COLUMNS;zi++)
        {
            g.drawLine(Window.getX(zi*xdelta),Window.getY(0),
                    Window.getX(zi*xdelta),Window.getY(Window.getHeight2()));
        }                
        
    }    
}
