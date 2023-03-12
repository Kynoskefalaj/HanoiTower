package rings;

import root.Board;
import root.Mechanics;

import javax.swing.*;
import java.awt.*;

public class Ring_250 extends Ring {

    public Ring_250(Mechanics mechanics, Board board){
        this.mechanics = mechanics;
        this.board = board;
        diameter = 250;
        color = Color.magenta;
        startPositionX = board.addressX[2];
        startPositionY = board.addressY[3];

        positionX = startPositionX;
        positionY = startPositionY;

        ringButton = new JButton("" + diameter);
        ringButton = mechanics.makeButton(this, ringButton, "" + diameter, color,
                "" + diameter);
    }
}
