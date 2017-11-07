
package stratego;

import java.awt.*;

public class Miner extends Piece{
    Miner(){
        super(Color.red, 0, 0, 3, true);
    }
    Miner(Color _color, int _row, int _col){
        super(_color, _row, _col, 3, true);
    }
    
}
