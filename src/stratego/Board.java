
package stratego;

import java.awt.*;

public class Board {
    private final static int NUM_ROWS = 10;
    private final static int NUM_COLUMNS = 10;      
    private static Piece board[][] = new Piece[NUM_ROWS][NUM_COLUMNS];
    private static int selectedRow;
    private static int selectedColumn;
    public static boolean selected = false;
    public static void Reset() {
        for (int zi = 0;zi<NUM_ROWS;zi++)
        {
            for (int zx = 0;zx<NUM_COLUMNS;zx++)
            {
                board[zi][zx] = null;
            }
            selected = false;
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
                
        for (int zi = 0;zi<NUM_ROWS;zi++)
        {
            for (int zx = 0;zx<NUM_COLUMNS;zx++)
            {
                if (board[zi][zx] != null)
                {
                    board[zi][zx].draw(g,zi,zx,xdelta,ydelta);
                }
            }
        }                
<<<<<<< Updated upstream
        
    }  
    public static void AddPiecePixel(int xpixel,int ypixel,Graphics2D g) {
=======
    }
    public static void AddPiecePixel(int xpixel,int ypixel) {
>>>>>>> Stashed changes
        
        
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
<<<<<<< Updated upstream
        if(board[zrow][zcol]==null ){
            if(board[zrow]!=board[4] && board[zrow]!=board[5])
           board[zrow][zcol] = new Piece(currentColor);
        }
        
}
    public static void selectPiece(int xpixel,int ypixel){
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
        if(board[zrow][zcol]!=null){
        selectedRow = zrow;
        selectedColumn = zcol;
         board[selectedRow][selectedColumn].setColor(Color.yellow);
         selected = true;
        }
    }
//    public static void movePieceHorizontal(int move){
//        board[selectedRow][selectedColumn].moveHorizontal(move);
//    }
//    public static void movePieceVertical(int move){
//        selectedPiece[selectedRow][selectedColumn].moveVertical(move);
//    }
//    public static void movePiece(int xpixel,int ypixel){
//        if(board[selectedRow][selectedColumn]!=null){
//        int ydelta = Window.getHeight2()/NUM_ROWS;
//        int xdelta = Window.getWidth2()/NUM_COLUMNS;
//
//        int zcol = 0;
//        int zrow = 0;
//        
//        if (xpixel-Window.getX(0) > 0 &&
//            ypixel-Window.getY(0) > 0 &&
//            xpixel-Window.getX(0) < xdelta*NUM_COLUMNS &&
//            ypixel-Window.getY(0) < ydelta*NUM_ROWS)
//        {
//            zcol = (xpixel-Window.getX(0))/xdelta;
//            zrow = (ypixel-Window.getY(0))/ydelta;
//        }
//        if(board[zrow][zcol] == board[selectedRow][selectedColumn+1] || board[zrow][zcol] == board[selectedRow][selectedColumn-1] 
//                || board[zrow][zcol] == board[selectedRow-1][selectedColumn] || board[zrow][zcol] == board[selectedRow+1][selectedColumn]){
//        board[selectedRow][selectedColumn]=null;
//        board[zrow][zcol] = new Piece(Color.RED);
//        }
//    }
//    }
    public static void movePiece(int move){
        int newRow=0;
        int newCol=0;
        
        if(move==-1){
            newCol=selectedColumn-1;
            newRow=selectedRow;
           board[newRow][newCol] =board[selectedRow][selectedColumn]; 
        }
        else if(move==1){
            newCol=selectedColumn+1;
            newRow=selectedRow;
           board[newRow][newCol] = board[selectedRow][selectedColumn];
        }
        else if(move==3){
            newCol=selectedColumn;
            newRow=selectedRow-1;
           board[newRow][newCol] =board[selectedRow][selectedColumn];
        }
        else if(move==4){
            newCol=selectedColumn;
            newRow=selectedRow+1;
           board[newRow][newCol] =board[selectedRow][selectedColumn];
=======
        if(board[zrow][zcol]==null){
           board[zrow][zcol] = new Piece(currentColor);
           
>>>>>>> Stashed changes
        }
        selected= false;
        board[selectedRow][selectedColumn]=null;
}
}
