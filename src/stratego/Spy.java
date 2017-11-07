
package stratego;

import java.awt.*;

public class Spy extends Piece{
    Spy(){
        super(Color.red, 0, 0, 1, true);
    }
    Spy(Color _color, int _row, int _col){
        super(_color, _row, _col, 1, true);
    }
}
