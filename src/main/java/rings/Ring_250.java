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
        index = "A4";
        color = Color.magenta;

        board.slotOccupiance.replace(index, this);

        startPositionX = board.dictX.get(index);
        startPositionY = board.dictY.get(index);

        positionX = startPositionX;
        positionY = startPositionY;

        ringButton = new JButton("" + diameter);
        ringButton = mechanics.makeButton(this, ringButton, "" + diameter, color,
                "" + diameter);
    }
}
