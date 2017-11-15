
package stratego;

import java.awt.*;

public class Scout extends Piece{
    public int lockedRow = 0;
    public int lockedCol = 0;
    public boolean RowLocked = false;
    public boolean ColLocked = false;
    Scout(){
        super(Color.red, 0, 0, 2, true);
    }
    Scout(Color _color, int _row, int _col){
        super(_color, _row, _col, 2, true);
    }
    
}
