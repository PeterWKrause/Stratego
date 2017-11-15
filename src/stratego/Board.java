
package stratego;

import java.awt.*;

public class Board {
    
    private final static int NUM_ROWS = 10;
    private final static int NUM_COLUMNS = 10;      
    public static Piece board[][] = new Piece[NUM_ROWS][NUM_COLUMNS];
    public static int selectedRow;
    public static int selectedColumn;
    public static boolean selected = false;
    public static boolean Victory = false;
    

    public static boolean turn = false;
    
    public static void Reset() {
        for (int zi = 0;zi<NUM_ROWS;zi++)
        {
            for (int zx = 0;zx<NUM_COLUMNS;zx++)
            {
                board[zi][zx] = null;
            }
            selected = false;
            Victory=false;
            turn = false;
        }

    }
    public static void ChangeDelayed(){
        for(int zrow = 0; zrow<NUM_ROWS;zrow++)
            for(int zcol = 0; zcol<NUM_COLUMNS;zcol++)
                if(board[zrow][zcol]!=null)
                    if(board[zrow][zcol].getDelayed())
                        board[zrow][zcol].setDelayedFalse();
    }
    
    public static void Draw(Graphics2D g) {
        if(Stratego.start)
            return;
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
        if(Stratego.start)
            return;
        
        
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
        if(turn)
            currentColor = Color.blue;
        
        if(board[zrow][zcol]==null ){
            if(board[zrow]!=board[4] && board[zrow]!=board[5]){
                if(!turn)
            board[zrow][zcol] = Piece.Create(Commands.ReadRank(),currentColor, zrow, zcol);
                else
                    board[zrow][zcol] = Piece.Create(Commands.ReadRank(),currentColor, zrow, zcol);
            }
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
        
        if(board[zrow][zcol]!=null )
            return(false);
        if(board[zrow]==board[4] || board[zrow]==board[5])
           return(false);
            if(zrow>5 && turn!=false )
                return(false);
            if(zrow<4 && turn!=true)
                return(false);
            return(true);
    }
    public static void selectPiece(int xpixel,int ypixel){
        if(Stratego.start)
            return;
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
        if(!board[selectedRow][selectedColumn].getMobile())
            return;
         board[selectedRow][selectedColumn].setColor(Color.magenta);
         selected = true;
        }
    }
    
    public static void movePiece(int move){
        if(Stratego.start)
            return;
        if(board[selectedRow][selectedColumn].getDelayed() || !board[selectedRow][selectedColumn].getMobile())
            return;
        int newRow=0;
        int newCol=0;
        boolean test = false;
        if(turn == false){
            turn = true;
            ChangeDelayed();
        }
        else{
            Board.turn = false;
            ChangeDelayed();
        }
        
        if(move==-1&& selectedColumn!=0){//move left
            if(selectedColumn==4 && (selectedRow==4|| selectedRow==5)){
                board[selectedRow][selectedColumn].setDelayedTrue();
            }
            if(selectedColumn==8 && (selectedRow==4|| selectedRow==5)){
                board[selectedRow][selectedColumn].setDelayedTrue();
            }
            newCol=selectedColumn-1;
            newRow=selectedRow;
            if(board[newRow][newCol]!=null){
                if(!testTeams(newRow,newCol,selectedRow,selectedColumn))
                   return;
                if(!strikePiece(newRow,newCol,selectedRow,selectedColumn))
                return;
            }
           board[newRow][newCol] =board[selectedRow][selectedColumn]; 
           test = true;
        
        }
        else if(move==1&& selectedColumn!=NUM_COLUMNS-1){//move right
            if(selectedColumn==5 && (selectedRow==4|| selectedRow==5))
                board[selectedRow][selectedColumn].setDelayedTrue();
            if(selectedColumn==1 && (selectedRow==4|| selectedRow==5))
                board[selectedRow][selectedColumn].setDelayedTrue();
            newCol=selectedColumn+1;
            newRow=selectedRow;
            if(board[newRow][newCol]!=null){
                if(!testTeams(newRow,newCol,selectedRow,selectedColumn))
                   return;
                if(!strikePiece(newRow,newCol,selectedRow,selectedColumn))
                return;
            }
           board[newRow][newCol] = board[selectedRow][selectedColumn];
           test =true;
        }
        else if(move==3 && selectedRow!=0){ //move up
            if(selectedRow==6 && (selectedColumn==2|| selectedColumn==3))
                board[selectedRow][selectedColumn].setDelayedTrue();
            if(selectedRow==6 && (selectedColumn==6|| selectedColumn==7))
                board[selectedRow][selectedColumn].setDelayedTrue();
            newCol=selectedColumn;
            newRow=selectedRow-1;
            if(board[newRow][newCol]!=null){
                if(!testTeams(newRow,newCol,selectedRow,selectedColumn))
                   return;
                if(!strikePiece(newRow,newCol,selectedRow,selectedColumn))
                return;
            }
           board[newRow][newCol] =board[selectedRow][selectedColumn];
           test =true;
        }
        else if(move==4 && selectedRow!=NUM_ROWS-1){ //move down
            if(selectedRow==3 && (selectedColumn==2|| selectedColumn==3))
                board[selectedRow][selectedColumn].setDelayedTrue();
            if(selectedRow==3 && (selectedColumn==6|| selectedColumn==7))
                board[selectedRow][selectedColumn].setDelayedTrue();
            newCol=selectedColumn;
            newRow=selectedRow+1;
            if(board[newRow][newCol]!=null){
                if(!testTeams(newRow,newCol,selectedRow,selectedColumn))
                   return;
                if(!strikePiece(newRow,newCol,selectedRow,selectedColumn))
                return;
                
            }
           board[newRow][newCol] =board[selectedRow][selectedColumn];
           test =true;
            }
        
        if(test==true &&board[newRow][newCol]!=null){
        selected= false;
        board[selectedRow][selectedColumn]=null;
        if(!board[newRow][newCol].getTeam())
        board[newRow][newCol].setColor(Color.red);
        else
        board[newRow][newCol].setColor(Color.blue);
        }
        
}
     public static boolean strikePiece(int defendingRow, int defendingCol,int attackingRow,int attackingCol){
         //defender is flag
         if(board[defendingRow][defendingCol] instanceof Flag){
            board[defendingRow][defendingCol]=null;     
            if(board[attackingRow][attackingCol].getRank()<10)
            board[attackingRow][attackingCol].RankUp();
            Victory = true;
            return(true);
         }//attacker is miner and defender is bomb
         else if(board[attackingRow][attackingCol] instanceof Miner
                 && board[defendingRow][defendingCol] instanceof Bomb){
                board[defendingRow][defendingCol]=null;     
                if(board[attackingRow][attackingCol].getRank()<10)
                board[attackingRow][attackingCol].RankUp();
                return(true);                 
             
         }//attacker is spy and defender is rank 10
         else if(board[attackingRow][attackingCol] instanceof Spy 
                 && board[defendingRow][defendingCol].getRank()==10){
             
                board[defendingRow][defendingCol]=null;     
                return(true);
             }
        //attacker wins
         else if(board[attackingRow][attackingCol] instanceof Miner && board[defendingRow][defendingCol] instanceof Bomb){
                board[defendingRow][defendingCol]=null;     
                if(board[attackingRow][attackingCol].getRank()<10)
                board[attackingRow][attackingCol].RankUp();
                return(true);      
         }//attacker is spy and defender is rank 10
         else if(board[attackingRow][attackingCol] instanceof Spy && board[defendingRow][defendingCol].getRank()==10){
            board[defendingRow][defendingCol]=null;     
            return(true);
         }//attacker wins
         else if(board[defendingRow][defendingCol].getRank()<board[attackingRow][attackingCol].getRank()){
        board[defendingRow][defendingCol]=null; 
        if(board[attackingRow][attackingCol].getRank()<10)
        board[attackingRow][attackingCol].RankUp();
        return(true);
         }//defender wins
         else if(board[defendingRow][defendingCol].getRank()>board[attackingRow][attackingCol].getRank()){
        board[attackingRow][attackingCol]=null;
             board[defendingRow][defendingCol] = board[defendingRow][defendingCol];
             if(board[defendingRow][defendingCol].getRank()<10)
             board[defendingRow][defendingCol].RankUp();
             return(false);
         }//tie
         else if(board[defendingRow][defendingCol].getRank()==board[attackingRow][attackingCol].getRank()){
        board[defendingRow][defendingCol]=null; 
        board[attackingRow][attackingCol]=null;
        return(true);
         }
         return(false);
     }
     public static boolean testTeams(int _newRow,int _newCol,int _selectedRow,int _selectedCol){
         if(board[_newRow][_newCol].getTeam()==board[_selectedRow][_selectedCol].getTeam())
             return(false);
         else
         return(true);
     }
}
