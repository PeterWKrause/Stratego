
package stratego;

import java.awt.*;

public class Piece {
    private Color color;
    private int rank;
    private int row;
    private int column;
<<<<<<< Updated upstream
    private boolean mobile;
    
    
    static int numBombs = 6;
    static int numFlags = 1;
    static int numSpies = 1;
    static int numScouts = 8;
    static int numMiners = 5;
    static int numSergeants = 4;
    static int numLieutenants = 4;
    static int numCaptains = 4;
    static int numMajors = 3;
    static int numColonels = 2;
    static int numGenerals = 1;
    static int numMarshalls = 1;
    
    Piece(Color _color, int _row, int _col, int _rank, boolean _mobile){
        color = _color;
        row = _row;
        column = _col;
        rank = _rank;
        mobile = _mobile;
=======
    private boolean hidden;
    Piece(Color _color, int _row, int _column){
        color=_color;
        row = _row;
        column = _column;
        rank = (int)(Math.random()*5);
        hidden = true;
>>>>>>> Stashed changes
    }
    public Color getColor()
    {
        return (color);
    }
    public int getRank()
    {
        return (rank);
    }
    public void draw(Graphics2D g,int _row,int _column,
    int xdelta,int ydelta) {
        g.setColor(color); 
        g.fillRect(Window.getX(column*xdelta)+5,
        Window.getY(row*ydelta)+5,xdelta-10,ydelta-10);
        
//        if(!hidden){
        g.setColor(Color.white);
        g.setFont(new Font("Arial",Font.PLAIN,30));
        g.drawString("" + rank,Window.getX(column*xdelta)+30,Window.getY(row*ydelta)+40); 
//        }
        row = _row;
        column = _column;
    }
    public static Piece Create(int _rank,Color currentColor,int zrow,int zcol){
        if(_rank==0 && numFlags>0){
            numFlags--; 
            return(new Flag(currentColor, zrow, zcol)); }
        else if(_rank==1 && numSpies>0){
            numSpies--;
            return(new Spy(currentColor, zrow, zcol));}
        else if(_rank==2 && numScouts>0){
            numScouts--;
            return(new Scout(currentColor, zrow, zcol));}
        else if(_rank==3 && numMiners>0){
            numMiners--;
            return(new Miner(currentColor, zrow, zcol));}
        else if(_rank==4 && numSergeants>0){
            numSergeants--;
            return(new Piece(currentColor, zrow, zcol, _rank, true));}
        else if(_rank==5 && numLieutenants>0){
            numLieutenants--;
            return(new Piece(currentColor, zrow, zcol, _rank, true));}
        else if(_rank==6 && numCaptains>0){
            numCaptains--;
            return(new Piece(currentColor, zrow, zcol, _rank, true));}
        else if(_rank==7 && numMajors>0){
            numMajors--;
            return(new Piece(currentColor, zrow, zcol, _rank, true));}
        else if(_rank==8 && numColonels>0){
            numColonels--;
            return(new Piece(currentColor, zrow, zcol, _rank, true));}
        else if(_rank==9 && numGenerals>0){
            numGenerals--;
            return(new Piece(currentColor, zrow, zcol, _rank, true));}
        else if(_rank==10 && numMarshalls>0){
            numMarshalls--;
            return(new Piece(currentColor, zrow, zcol, _rank, true));}
        else if(_rank==11 && numBombs>0){
            numBombs--;
            return(new Bomb(currentColor, zrow, zcol));}
        System.out.println("There are no available units of that rank remaining.");
        Stratego.decreaseCount();
        return(null);
    }
    public int getRow(){
        return(row);
    }
    public int getColumn(){
        return(row);
    }
    public void moveHorizontal(int move) {
        column+=move;
    }
    public void moveVertical(int move) {
        row+=move;
    }
    public void setColor(Color _color){
        color = _color;
    }
    public void setHidden(boolean _hidden){
        hidden = _hidden;
    }
    
}
