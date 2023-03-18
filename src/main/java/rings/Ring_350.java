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
        index = "A2";
        color = Color.red;

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