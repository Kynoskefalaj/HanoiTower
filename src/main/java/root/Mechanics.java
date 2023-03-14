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


    public void lastOneCheck (Ring ring, int column) {
        if (ring.positionY == 625 && column == 1150) {
            board.rightLastDiameter = 450;
        } else if (ring.positionY == 625 && column == 700) {
            board.middleLastDiameter = 450;
        } else if (ring.positionY == 625 && column == 250) {
            board.leftLastDiameter = 450;
        }
    }

    public void moveTo(Ring ring, int column) {

        //check if chosen ring is on top
        if (isFromTop(ring)) {
            //check from which column is moved ring
            //lower last empty slot in that column by 50
            if (ring.positionX == 1150) {
                board.rightLastSlot = ring.positionY;
            } else if (ring.positionX == 700) {
                board.middleLastSlot = ring.positionY;
            } else {
                board.leftLastSlot = ring.positionY;
            }
            //change moved ring posX to X of selected column
            //set moved ring posY to last empty slot of that column
            if (column == 1150 && ring.diameter < board.rightLastDiameter) {
                ring.positionY = board.rightLastSlot;
                ring.positionX = column;
                //execute
                ring.ringButton.setBounds(ring.positionX - ring.diameter / 2,
                        ring.positionY - 25, ring.diameter, 50);

                board.rightLastSlot -= 50;
                board.rightLastDiameter = ring.diameter;
            } else if (column == 700 && ring.diameter < board.middleLastDiameter) {
                //check if left slot was the last and if so, then set there max diameter of
                // default virtual ring
                if (ring.positionY == 625){
                    lastOneCheck(ring, 700);
                }
                ring.positionY = board.middleLastSlot;
                ring.positionX = column;
                //execute
                ring.ringButton.setBounds(ring.positionX - ring.diameter / 2,
                        ring.positionY - 25, ring.diameter, 50);

                board.middleLastSlot -= 50;
                board.middleLastDiameter = ring.diameter;
            } else if (column == 250 && ring.diameter < board.leftLastDiameter){
                ring.positionY = board.leftLastSlot;
                ring.positionX = column;
                //execute
                ring.ringButton.setBounds(ring.positionX - ring.diameter / 2,
                        ring.positionY - 25, ring.diameter, 50);

                board.leftLastSlot -= 50;
                board.leftLastDiameter = ring.diameter;
            }

            //check if moved ring was the last one in column so we have to set max diameter there


        } else {
            //if it is not on top then do nothing
        }
    }
}
