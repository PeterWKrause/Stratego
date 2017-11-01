
package stratego;

import java.awt.*;

public class Piece {
    private Color color;
    private int rank;
    
    Piece(){
        color=null;
        
    }
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
    public void draw(Graphics2D g,int row,int column,
    int xdelta,int ydelta) {
        g.setColor(color); 
        g.fillRect(Window.getX(column*xdelta)+20,
        Window.getY(row*ydelta)+20,xdelta-20,ydelta-20);
        
//        g.setColor(Color.white);
//        g.setFont(new Font("Arial",Font.PLAIN,30));
//        g.drawString("" + rank,Window.getX(column*xdelta)+30,
//        Window.getY(row*ydelta)+40);           
    }
}
