package rings;

import root.Mechanics;
import javax.swing.*;
import java.awt.*;
import root.Board;

public class Ring_400 extends Ring {

    public Ring_400(Mechanics mechanics, Board board){
        this.mechanics = mechanics;
        this.board = board;
        diameter = 400;
        color = Color.green;
        startPositionX = board.addressX[2];
        startPositionY = board.addressY[0];

        positionX = startPositionX;
        positionY = startPositionY;

        ringButton = new JButton("" + diameter);
        ringButton = mechanics.makeButton(this, ringButton, "" + diameter, color,
                "" + diameter);
    }


}
