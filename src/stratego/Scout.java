
package stratego;

import java.awt.*;

public class Scout extends Piece{
    Scout(){
        super(Color.red, 0, 0, 2, true);
    }
    Scout(Color _color, int _row, int _col){
        super(_color, _row, _col, 2, true);
    }
    
}
