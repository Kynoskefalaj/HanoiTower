package rings;

import root.Board;
import root.Mechanics;

import javax.swing.*;
import java.awt.*;

public class Ring_50 extends Ring {

    public Ring_50(Mechanics mechanics, Board board){
        this.mechanics = mechanics;
        this.board = board;
        diameter = 50;
        color = Color.GRAY;
        startPositionX = board.addressX[2];
        startPositionY = board.addressY[7];

        positionX = startPositionX;
        positionY = startPositionY;

        ringButton = new JButton("" + diameter);
        ringButton = mechanics.makeButton(this, ringButton, "" + diameter, color,
                "" + diameter);
    }
}
