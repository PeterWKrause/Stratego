
package stratego;

import java.awt.*;

public class Piece {
    private Color color;
    private int rank;
    private int row;
    private int column;
    
    Piece(Color _color){
        color=_color;
        
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
        g.fillRect(Window.getX(column*xdelta)+20,
        Window.getY(row*ydelta)+20,xdelta-20,ydelta-20);
        
        g.setColor(Color.white);
        g.setFont(new Font("Arial",Font.PLAIN,30));
        g.drawString("" + rank,Window.getX(column*xdelta)+30,
        Window.getY(row*ydelta)+40); 

        row = _row;
        column = _column;
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
}
