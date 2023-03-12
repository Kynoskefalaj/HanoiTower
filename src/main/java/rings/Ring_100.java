package rings;

import root.Board;
import root.Mechanics;

import javax.swing.*;
import java.awt.*;

public class Ring_100 extends Ring {

    public Ring_100(Mechanics mechanics, Board board){
        this.mechanics = mechanics;
        this.board = board;
        diameter = 100;
        color = Color.WHITE;
        startPositionX = board.addressX[2];
        startPositionY = board.addressY[6];

        positionX = startPositionX;
        positionY = startPositionY;

        ringButton = new JButton("" + diameter);
        ringButton = mechanics.makeButton(this, ringButton, "" + diameter, color,
                "" + diameter);
    }
}
