package rings;

import root.Mechanics;
import javax.swing.*;
import java.awt.*;
import root.Board;

public class Ring_400 extends Ring {

    public Ring_400(Mechanics mechanics, Board board){
        diameter = 400;
        color = Color.green;
        startPositionX = board.addressX[2];
        startPositionY = board.addressY[0];

        positionX = startPositionX;
        positionY = startPositionY;

        ringButton = new JButton();
        ringButton = mechanics.makeButton(ringButton, "" + diameter, color,
                "" + diameter);



    }


}
