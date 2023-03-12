package rings;
import root.Mechanics;
import javax.swing.*;
import java.awt.*;
import root.Board;

public class Ring_350 extends Ring {

    public Ring_350(Mechanics mechanics, Board board) {
        this.mechanics = mechanics;
        this.board = board;
        diameter = 350;
        color = Color.red;
        startPositionX = board.addressX[2];
        startPositionY = board.addressY[1];

        positionX = startPositionX;
        positionY = startPositionY;

        ringButton = new JButton("" + diameter);
        ringButton = mechanics.makeButton(this, ringButton, "" + diameter, color,
                "" + diameter);
    }
}