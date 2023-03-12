package rings;

import root.Board;
import root.Mechanics;

import javax.swing.*;
import java.awt.*;

public class Ring {
    public int diameter;
    public Color color;
    public JButton ringButton;
    public Board board;
    public Mechanics mechanics;
    public int index;
    public int positionX, startPositionX;
    public int positionY, startPositionY;

//    public Ring(Mechanics mechanics, Board board){
//        this.mechanics = mechanics;
//        this.board = board;
//
//        ringButton = new JButton("" + diameter);
//        ringButton = mechanics.makeButton(this, ringButton, "" + diameter, color,
//                "" + diameter);
//    }
}
