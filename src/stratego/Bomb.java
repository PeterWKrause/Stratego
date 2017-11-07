
package stratego;

import java.awt.*;

public class Bomb extends Piece{
    Bomb(){
        super(Color.red, 0, 0, 11, false);
    }
    Bomb(Color _color, int _row, int _col){
        super(_color, _row, _col, 11, false);
    }
    
}
