
package stratego;

import java.awt.*;

public class Board {
    private final static int NUM_ROWS = 10;
    private final static int NUM_COLUMNS = 10;      
    private static Piece board[][] = new Piece[NUM_ROWS][NUM_COLUMNS];

    public static void Reset() {
        for (int zi = 0;zi<NUM_ROWS;zi++)
        {
            for (int zx = 0;zx<NUM_COLUMNS;zx++)
            {
                board[zi][zx] = null;
            }
        }

    }
    
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
    public static void AddPiecePixel(int xpixel,int ypixel) {
        
        
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;

        int zcol = 0;
        int zrow = 0;
        
        if (xpixel-Window.getX(0) > 0 &&
            ypixel-Window.getY(0) > 0 &&
            xpixel-Window.getX(0) < xdelta*NUM_COLUMNS &&
            ypixel-Window.getY(0) < ydelta*NUM_ROWS)
        {
            zcol = (xpixel-Window.getX(0))/xdelta;
            zrow = (ypixel-Window.getY(0))/ydelta;
        }
        Color currentColor = Color.red;
        if(board[zrow][zcol]==null){
           // board[zrow][zcol] = new Piece(currentColor);
            
        }
}
}
