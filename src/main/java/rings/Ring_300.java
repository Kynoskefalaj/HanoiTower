package rings;

import root.Board;
import root.Mechanics;

import javax.swing.*;
import java.awt.*;

public class Ring_300 extends Ring {

    public Ring_300(Mechanics mechanics, Board board) {
        this.mechanics = mechanics;
        this.board = board;
        diameter = 300;
        color = Color.yellow;
        startPositionX = board.addressX[2];
        startPositionY = board.addressY[2];

        positionX = startPositionX;
        positionY = startPositionY;

        ringButton = new JButton("" + diameter);
        ringButton = mechanics.makeButton(this, ringButton, "" + diameter, color,
                "" + diameter);
    }
}
