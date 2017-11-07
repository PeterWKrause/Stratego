
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
        else return;
        Color currentColor = Color.red;

        if(board[zrow][zcol]==null ){
<<<<<<< Updated upstream
            if(board[zrow]!=board[4] && board[zrow]!=board[5]){
            board[zrow][zcol] = Piece.Create(Commands.ReadRank(),currentColor, zrow, zcol);
            }
=======
            if(board[zrow]!=board[4] && board[zrow]!=board[5])
           board[zrow][zcol] = new Piece(currentColor,zrow,zcol);
>>>>>>> Stashed changes
        }
        
}
    public static boolean testSpot(int xpixel, int ypixel){
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
        else return(false);
        if(board[zrow][zcol]==null ){
            if(board[zrow]!=board[4] && board[zrow]!=board[5])
           return(true);
        }
        return(false);
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
         board[selectedRow][selectedColumn].setColor(Color.magenta);
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
        boolean test = false;
        
        if(move==-1&& selectedColumn!=0){//move left
            if(selectedColumn==4 && (selectedRow==4|| selectedRow==5))
                return;
            if(selectedColumn==8 && (selectedRow==4|| selectedRow==5))
                return;
            newCol=selectedColumn-1;
            newRow=selectedRow;
            if(board[newRow][newCol]!=null){
                if(!strikePiece(newRow,newCol,selectedRow,selectedColumn))
                return;
            }
           board[newRow][newCol] =board[selectedRow][selectedColumn]; 
           test = true;
        
        }
        else if(move==1&& selectedColumn!=NUM_COLUMNS-1){//move right
            if(selectedColumn==5 && (selectedRow==4|| selectedRow==5))
                return;
            if(selectedColumn==1 && (selectedRow==4|| selectedRow==5))
                return;
            newCol=selectedColumn+1;
            newRow=selectedRow;
            if(board[newRow][newCol]!=null){
                if(!strikePiece(newRow,newCol,selectedRow,selectedColumn))
                return;
            }
           board[newRow][newCol] = board[selectedRow][selectedColumn];
           test =true;
        }
        else if(move==3 && selectedRow!=0){ //move up
            if(selectedRow==6 && (selectedColumn==2|| selectedColumn==3))
                return;
            if(selectedRow==6 && (selectedColumn==6|| selectedColumn==7))
                return;
            newCol=selectedColumn;
            newRow=selectedRow-1;
            if(board[newRow][newCol]!=null){
                if(!strikePiece(newRow,newCol,selectedRow,selectedColumn))
                return;
            }
           board[newRow][newCol] =board[selectedRow][selectedColumn];
           test =true;
        }
        else if(move==4 && selectedRow!=NUM_ROWS-1){ //move down
            if(selectedRow==3 && (selectedColumn==2|| selectedColumn==3))
                return;
            if(selectedRow==3 && (selectedColumn==6|| selectedColumn==7))
                return;
            newCol=selectedColumn;
            newRow=selectedRow+1;
            if(board[newRow][newCol]!=null){
                if(!strikePiece(newRow,newCol,selectedRow,selectedColumn))
                return;
                
            }
           board[newRow][newCol] =board[selectedRow][selectedColumn];
           test =true;
            }
        
        if(test==true &&board[newRow][newCol]!=null){
        selected= false;
        board[selectedRow][selectedColumn]=null;
        board[newRow][newCol].setColor(Color.red);
        }
        
}
     public static boolean strikePiece(int defendingRow, int defendingCol,int attackingRow,int attackingCol){
         board[defendingRow][defendingCol].setHidden(false);
         board[attackingRow][attackingCol].setHidden(false);
         
         //attacker wins
         if(board[defendingRow][defendingCol].getRank()<board[attackingRow][attackingCol].getRank()){
        board[defendingRow][defendingCol]=null; 
        return(true);
         }//defender wins
         else if(board[defendingRow][defendingCol].getRank()>board[attackingRow][attackingCol].getRank()){
        board[attackingRow][attackingCol]=null;
             board[defendingRow][defendingCol] = board[defendingRow][defendingCol];
             return(false);
         }//tie
         else if(board[defendingRow][defendingCol].getRank()==board[attackingRow][attackingCol].getRank()){
        board[defendingRow][defendingCol]=null; 
        board[attackingRow][attackingCol]=null;
        return(true);
         }
         return(false);
     }
}
