
package stratego;

import java.awt.*;

public class Piece {
    private Color color;
    private int rank;
    private int row;
    private int column;
    private boolean mobile;
    private boolean hidden;
    private boolean team;
    private boolean delayed = false;
    private String name;
    
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
    public static Stratego stratego;
    
    Image flag = Toolkit.getDefaultToolkit().getImage("./Flag.PNG");
    Image spy = Toolkit.getDefaultToolkit().getImage("./Spy.PNG");
    Image scout = Toolkit.getDefaultToolkit().getImage("./Scout.PNG");
    Image miner = Toolkit.getDefaultToolkit().getImage("./Miner.PNG");
    Image  sergeant = Toolkit.getDefaultToolkit().getImage("./Sergeant.PNG");
    Image lieutenant = Toolkit.getDefaultToolkit().getImage("./Lieutenant.PNG");
    Image captain = Toolkit.getDefaultToolkit().getImage("./Captain.PNG");
    Image major = Toolkit.getDefaultToolkit().getImage("./Major.PNG");
    Image colonel = Toolkit.getDefaultToolkit().getImage("./Colonel.PNG");
    Image general = Toolkit.getDefaultToolkit().getImage("./General.PNG");
    Image marshal = Toolkit.getDefaultToolkit().getImage("./Marshal.PNG");
<<<<<<< Updated upstream
    Image bomb = Toolkit.getDefaultToolkit().getImage("./Bomb.PNG");
    
=======

>>>>>>> Stashed changes
    static int numBombs2 = 6;
    static int numFlags2 = 1;
    static int numSpies2 = 1;
    static int numScouts2 = 8;
    static int numMiners2 = 5;
    static int numSergeants2 = 4;
    static int numLieutenants2 = 4;
    static int numCaptains2 = 4;
    static int numMajors2 = 3;
    static int numColonels2 = 2;
    static int numGenerals2 = 1;
    static int numMarshalls2 = 1;    
    
    Piece(Color _color, int _row, int _col, int _rank, boolean _mobile){
        color = _color;
        row = _row;
        column = _col;
        rank = _rank;
        mobile = _mobile;
        if(color==Color.red)
            team = false;
        else
            team = true;
    }
    public Color getColor()
    {
        return (color);
    }
    public int getRank()
    {
        return (rank);
    }
    public boolean getMobile()
    {
        return(mobile);
    }
    public boolean getDelayed()
    {
        return(delayed);
    }
    public void setDelayedTrue(){
        delayed = true;
    }
    public void setDelayedFalse(){
        delayed = false;
    }
    public void setName(){
        if(rank == 0)
            name = "Flag";
        else if(rank == 1)
            name = "Spy";
        else if(rank == 2)
            name = "Scout";        
        else if(rank == 3)
            name = "Miner";        
        else if(rank == 4)
            name = "Sergeant";
        else if(rank == 5)
            name = "Lieutenant";
        else if(rank == 6)
            name = "Captain";
        else if(rank == 7)
            name = "Major";
        else if(rank == 8)
            name = "Colonel";
        else if(rank == 9)
            name = "General";
        else if(rank == 10)
            name = "Marshall";
        else if(rank == 11)
            name = "Bomb";        
    }

    
    public void draw(Graphics2D g,int _row,int _column,
    int xdelta,int ydelta) {
        
        g.setColor(color); 
        g.fillRect(Window.getX(column*xdelta),Window.getY(row*ydelta),xdelta,ydelta); 
        if(rank==0)
            g.drawImage(flag, Window.getX(column*xdelta)+5, Window.getY(row*ydelta)+5, xdelta-10, ydelta-10,stratego); 
        else if(rank==1)
           g.drawImage(spy, Window.getX(column*xdelta)+5, Window.getY(row*ydelta)+5, xdelta-10, ydelta-10
                ,stratego); 
        else if(rank==2)
            g.drawImage(scout, Window.getX(column*xdelta)+5, Window.getY(row*ydelta)+5, xdelta-10, ydelta-10
                ,stratego); 
        else if(rank==3)
            g.drawImage(miner, Window.getX(column*xdelta)+5, Window.getY(row*ydelta)+5, xdelta-10, ydelta-10
                ,stratego);    
        else if(rank==4)
                g.drawImage(sergeant, Window.getX(column*xdelta)+5, Window.getY(row*ydelta)+5, xdelta-10, ydelta-10
                ,stratego); 
        else if(rank==5)
                g.drawImage(lieutenant, Window.getX(column*xdelta)+5, Window.getY(row*ydelta)+5, xdelta-10, ydelta-10
                ,stratego); 
        else if(rank==6)
                g.drawImage(captain, Window.getX(column*xdelta)+5, Window.getY(row*ydelta)+5, xdelta-10, ydelta-10
                ,stratego); 
        else if(rank==7)
                g.drawImage(major, Window.getX(column*xdelta)+5, Window.getY(row*ydelta)+5, xdelta-10, ydelta-10
                ,stratego); 
        else if(rank==8)
                g.drawImage(colonel, Window.getX(column*xdelta)+5, Window.getY(row*ydelta)+5, xdelta-10, ydelta-10
                ,stratego); 
        else if(rank==9)
                g.drawImage(general, Window.getX(column*xdelta)+5, Window.getY(row*ydelta)+5, xdelta-10, ydelta-10
                ,stratego); 
        else if(rank==10)
             g.drawImage(marshal, Window.getX(column*xdelta)+5, Window.getY(row*ydelta)+5, xdelta-10, ydelta-10
                ,stratego); 
        else if(rank==11)
            g.drawImage(bomb, Window.getX(column*xdelta)+5, Window.getY(row*ydelta)+5, xdelta-10, ydelta-10
                ,stratego); 
        
        if(rank >= 10)
        {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial",Font.BOLD,13));
            g.drawString("" + rank,Window.getX(column*xdelta)-20+(xdelta/2)-2,Window.getY(row*ydelta)+(ydelta/2)-10); 
        }
        else
        {
            
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial",Font.BOLD,15));
            g.drawString("" + rank,Window.getX(column*xdelta)-20+(xdelta/2)-3,Window.getY(row*ydelta)+(ydelta/2)-8); 
        }
        
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial",Font.PLAIN,15));
        g.drawString("" + name,Window.getX(column*xdelta),Window.getY(row*ydelta)+ydelta); 
        
        row = _row;
        column = _column;
    }    
    public static Piece Create(int _rank,Color currentColor,int zrow,int zcol){

        if(_rank==0 && (numFlags>0 || numFlags2>0)){
        if(Board.turn == false){
            Board.turn = true;
            Board.ChangeDelayed();
        }
        else{
            Board.turn = false;
            Board.ChangeDelayed();
        }
            if(!Board.turn){
            numFlags--; 
            return(new Flag(currentColor, zrow, zcol)); }
            else if(Board.turn){
            numFlags2--;
            return(new Flag(currentColor, zrow, zcol)); }}
        else if(_rank==1 && (numSpies>0 || numSpies2>0)){
        if(Board.turn == false){
            Board.turn = true;
            Board.ChangeDelayed();
        }
        else{
            Board.turn = false;
            Board.ChangeDelayed();
        }
            if(!Board.turn){
            numSpies--;
            return(new Spy(currentColor, zrow, zcol)); }
            else if(Board.turn){
            numSpies2--;
            return(new Spy(currentColor, zrow, zcol));}}
        else if(_rank==2 && (numScouts>0 || numScouts2>0)){
        if(Board.turn == false){
            Board.turn = true;
            Board.ChangeDelayed();
        }
        else{
            Board.turn = false;
            Board.ChangeDelayed();
        }
            if(!Board.turn){
            numScouts--;
            return(new Scout(currentColor, zrow, zcol)); }
            else if(Board.turn){
            numScouts2--;
            return(new Scout(currentColor, zrow, zcol));}}
        else if(_rank==3 && (numMiners>0 || numMiners2>0)){
        if(Board.turn == false){
            Board.turn = true;
            Board.ChangeDelayed();
        }
        else{
            Board.turn = false;
            Board.ChangeDelayed();
        }
            if(!Board.turn){
            numMiners--;
            return(new Miner(currentColor, zrow, zcol)); }
            else if(Board.turn){
            numMiners2--;
            return(new Miner(currentColor, zrow, zcol));}}
        else if(_rank==4 && (numSergeants>0 || numSergeants2>0)){
        if(Board.turn == false){
            Board.turn = true;
            Board.ChangeDelayed();
        }
        else{
            Board.turn = false;
            Board.ChangeDelayed();
        }
            if(!Board.turn){
            numSergeants--;
            return(new Piece(currentColor, zrow, zcol, _rank, true)); }
            else if(Board.turn){
            numSergeants2--;
            return(new Piece(currentColor, zrow, zcol, _rank, true));}}
        else if(_rank==5 && (numLieutenants>0 || numLieutenants2>0)){
        if(Board.turn == false){
            Board.turn = true;
            Board.ChangeDelayed();
        }
        else{
            Board.turn = false;
            Board.ChangeDelayed();
        }
            if(!Board.turn){
            numLieutenants--;
            return(new Piece(currentColor, zrow, zcol, _rank, true)); }
            else if(Board.turn){
            numLieutenants2--;
            return(new Piece(currentColor, zrow, zcol, _rank, true));}}
        else if(_rank==6 && (numCaptains>0 || numCaptains2>0)){
        if(Board.turn == false){
            Board.turn = true;
            Board.ChangeDelayed();
        }
        else{
            Board.turn = false;
            Board.ChangeDelayed();
        }
            if(!Board.turn){
            numCaptains--;
            return(new Piece(currentColor, zrow, zcol, _rank, true)); }
            else if(Board.turn){
            numCaptains2--;
            return(new Piece(currentColor, zrow, zcol, _rank, true));}}
        else if(_rank==7 && (numMajors>0 || numMajors2>0)){
        if(Board.turn == false){
            Board.turn = true;
            Board.ChangeDelayed();
        }
        else{
            Board.turn = false;
            Board.ChangeDelayed();
        }
            if(!Board.turn){
            numMajors--;
            return(new Piece(currentColor, zrow, zcol, _rank, true)); }
            else if(Board.turn){
            numMajors2--;
            return(new Piece(currentColor, zrow, zcol, _rank, true));}}
        else if(_rank==8 && (numColonels>0 || numColonels2>0)){
        if(Board.turn == false){
            Board.turn = true;
            Board.ChangeDelayed();
        }
        else{
            Board.turn = false;
            Board.ChangeDelayed();
        }
            if(!Board.turn){
            numColonels--;
            return(new Piece(currentColor, zrow, zcol, _rank, true)); }
            else if(Board.turn){
            numColonels--;
            return(new Piece(currentColor, zrow, zcol, _rank, true));}}
        else if(_rank==9 && (numGenerals>0 || numGenerals2>0)){
        if(Board.turn == false){
            Board.turn = true;
            Board.ChangeDelayed();
        }
        else{
            Board.turn = false;
            Board.ChangeDelayed();
        }
            if(!Board.turn){
            numGenerals--;
            return(new Piece(currentColor, zrow, zcol, _rank, true)); }
            else if(Board.turn){
            numGenerals2--;
            return(new Piece(currentColor, zrow, zcol, _rank, true));}}
        else if(_rank==10 && (numMarshalls>0 || numMarshalls2>0)){
        if(Board.turn == false){
            Board.turn = true;
            Board.ChangeDelayed();
        }
        else{
            Board.turn = false;
            Board.ChangeDelayed();
        }
            if(!Board.turn){
            numMarshalls--;
            return(new Piece(currentColor, zrow, zcol, _rank, true)); }
            else if(Board.turn){
            numMarshalls2--;
            return(new Piece(currentColor, zrow, zcol, _rank, true));}}
        else if(_rank==11 && (numBombs>0 || numBombs2>0)){
        if(Board.turn == false){
            Board.turn = true;
            Board.ChangeDelayed();
        }
        else{
            Board.turn = false;
            Board.ChangeDelayed();
        }
            if(!Board.turn){
            numBombs--;
            return(new Bomb(currentColor, zrow, zcol)); }
            else if(Board.turn){
            numBombs2--;
            return(new Bomb(currentColor, zrow, zcol));}}
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
    public void RankUp(){
        rank++;
    }
    public boolean getTeam(){
        return(team);
    }
    public static void setObj(Stratego _obj){
        stratego = _obj;
    }
    
}
