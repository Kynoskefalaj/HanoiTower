package root;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Objects;

import rings.Ring;

public class Mechanics {
    UserInterface ui;
    Main main;
    Board board;

    public Mechanics(Main main, UserInterface ui, Board board){
        this.main = main;
        this.ui = ui;
        this.board = board;
    }


    // makes Button from Ring extended classes
    public JButton makeButton(Ring ring, JButton button, String name, Color color, String action){
        button.setBackground(color);
        button.setBounds(ring.startPositionX - ring.diameter/2,
                ring.startPositionY - 25, ring.diameter, 50);
        button.setName(name);
        button.setForeground(Color.black);
        button.setFont(ui.normalFont);
        button.addActionListener(main.handler);
        button.setActionCommand(action);
        button.setVisible(true);
        return button;
    }

    public boolean isFromTop (Ring selectedRing){

        LinkedList<Ring> occupiedPile = new LinkedList<>();

        for (String i : board.slotOccupiance.keySet()) {
            Ring foundedRing = board.slotOccupiance.get(i);
            if (Objects.isNull(foundedRing)){
                continue;
            }
            //checks if founded ring is in the same column as selected ring
            else if (selectedRing.positionX == foundedRing.positionX){
                occupiedPile.addLast(foundedRing);
            } else
                continue;
        }
        //now we have occupiedPile list with Rings in the same column as selected
        int minY = Integer.MAX_VALUE; //set first value as the lowest
        for (int i = 0; i < occupiedPile.size(); i++) {
            Ring checkedRing = occupiedPile.get(i);
            int checkedPositionY = checkedRing.positionY;
            if (minY > checkedPositionY) {
                minY = checkedPositionY;
            }
        }

        if (selectedRing.positionY == minY){
            return true;
        } else
            return false;
    }

    public String findTop(int column)

}
