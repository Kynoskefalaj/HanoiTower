package rings;

import root.Board;
import root.Mechanics;

import javax.swing.*;
import java.awt.*;

public class Ring_200 extends Ring {

    public Ring_200(Mechanics mechanics, Board board){
        this.mechanics = mechanics;
        this.board = board;

        diameter = 200;
        startIndex = "A5";
        index = startIndex;
        color = Color.BLUE;

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
