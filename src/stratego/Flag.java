
package stratego;

import java.awt.*;

public class Flag extends Piece{
    Flag(){
        super(Color.red, 0, 0, 0, false);
    }
    Flag(Color _color, int _row, int _col){
        super(_color, _row, _col, 0, false);
    }
    
}
