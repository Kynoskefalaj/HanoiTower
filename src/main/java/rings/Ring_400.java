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
        startIndex = "A1";
        index = startIndex;
        color = Color.green;

        //replaces null value with this ring body
        board.slotOccupiance.replace(index, this);


        startPositionX = board.dictX.get(index);
        startPositionY = board.dictY.get(index);

//        old method of giving coordinates \/
//        startPositionX = board.addressX[2];
//        startPositionY = board.addressY[0];

        positionX = startPositionX;
        positionY = startPositionY;

        ringButton = new JButton("" + diameter);
        ringButton = mechanics.makeButton(this, ringButton, "" + diameter, color,
                "" + diameter);
    }
}
