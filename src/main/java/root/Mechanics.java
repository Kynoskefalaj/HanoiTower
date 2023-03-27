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
    String lastRingIndex;
    int counter;
    public int move_SelectSwitch = 0;

    public Mechanics(Main main, UserInterface ui, Board board) {
        this.main = main;
        this.ui = ui;
        this.board = board;
    }


    // makes Button from Ring extended classes
    public JButton makeButton(Ring ring, JButton button, String name, Color color, String action) {
        button.setBackground(color);
        button.setBounds(ring.startPositionX - ring.diameter / 2,
                ring.startPositionY - 25, ring.diameter, 50);
        button.setName(name);
        button.setForeground(Color.black);
        button.setFont(ui.normalFont);
        button.addActionListener(main.handler);
        button.setActionCommand(action);
        button.setVisible(true);
        return button;
    }

    public boolean isFromTop(Ring selectedRing) {

        LinkedList<Ring> occupiedPile = new LinkedList<>();

        for (String i : board.slotOccupiance.keySet()) {
            Ring foundedRing = board.slotOccupiance.get(i);
            if (Objects.isNull(foundedRing)) {
                continue;
            }
            //checks if founded ring is in the same column as selected ring
            else if (selectedRing.positionX == foundedRing.positionX) {
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

        if (selectedRing.positionY == minY) {
            return true;
        } else
            return false;
    }


    public void lastOneCheck(Ring ring, int column) {
        if (ring.positionY == 625 && column == 1150) {
            board.rightLastDiameter = 450;
        } else if (ring.positionY == 625 && column == 700) {
            board.middleLastDiameter = 450;
        } else if (ring.positionY == 625 && column == 250) {
            board.leftLastDiameter = 450;
        }
    }

    public int diameterBelow(int column, Ring movedRing) {
        String lastRingIndex = null;
        boolean done = false;
        if (movedRing.positionY != 625){
            //checks movedRing position Y and calculate last ring position in that column after moveTo()
            int lastRingAltitude = movedRing.positionY + 50;
            //create table with all indexes on desired altitude

            //add every index with right altitude to the list
            for (String indexInY : board.dictY.keySet()) {
                if (board.dictY.get(indexInY) == lastRingAltitude) {
                    lastRingIndex = indexInY;
                    //search for index of desired position in specified column
                    for (String indexInX : board.dictX.keySet()) {
                            if (!Objects.equals(indexInX, lastRingIndex)) {
                                continue;
                                }
                        if (board.dictX.get(indexInX) == column) {
                            lastRingIndex = indexInX;
                            done = true;
                            break;
                        }
                    }
                }
                if (done){
                    break;
                }
            }
            //search for ring what is in position at specified index
            for (String i : board.slotOccupiance.keySet()) {
                if (Objects.equals(i, lastRingIndex)) {
                    Ring foundRing = board.slotOccupiance.get(i);
                    if (foundRing == null){
                        String test = "eeeeeeeeeeeee";
                    }
                    return foundRing.diameter;
                }
            }
        }
        return 450;
    }

    public String searchIndex(int x, int y){
        String searchedIndex;
        for (String iy : board.dictY.keySet()){
            if (board.dictY.get(iy) == y){
                searchedIndex = iy;
                for (String ix : board.dictX.keySet()){
                    if ( Objects.equals(searchedIndex, ix) && board.dictX.get(ix) == x){
                        return searchedIndex;
                    }
                }
            }
        }
        return null;
    }

    public void occuranceUpdate(Ring ring, String oldIndex, int newX, int newY){
        board.slotOccupiance.replace(oldIndex, null);
        //probably here below is source of bug
        String newIndex = searchIndex(newX, newY);
        board.slotOccupiance.replace(newIndex, ring);
        ring.index = newIndex;
    }

    public void moveTo(Ring ring, int column) {
        counter += 1;
//        ui.counter.setText("" + counter);

        //check if chosen ring is on top
        if (isFromTop(ring)) {
            String lastIndex;
            //check from which column is moved ring
            //lower last empty slot in that column by 50
            if (ring.positionX == 1150) {
                board.rightLastSlot = ring.positionY;
                board.rightLastDiameter = diameterBelow(1150, ring);
            } else if (ring.positionX == 700) {
                board.middleLastSlot = ring.positionY;
                board.middleLastDiameter = diameterBelow(700, ring);
            } else {
                board.leftLastSlot = ring.positionY;
                board.leftLastDiameter = diameterBelow(250, ring);
            }

            lastIndex = ring.index;

            //change moved ring posX to X of selected column
            //set moved ring posY to last empty slot of that column
            if (column == 1150 && ring.diameter <= board.rightLastDiameter) {
                ring.positionY = board.rightLastSlot;
                ring.positionX = column;
                //execute
                ring.ringButton.setBounds(ring.positionX - ring.diameter / 2,
                        ring.positionY - 25, ring.diameter, 50);

                board.rightLastSlot -= 50;
                board.rightLastDiameter = ring.diameter;
                occuranceUpdate(ring, lastIndex, 1150, ring.positionY);
            } else if (column == 700 && ring.diameter <= board.middleLastDiameter) {
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
                occuranceUpdate(ring, lastIndex, 700, ring.positionY);
            } else if (column == 250 && ring.diameter <= board.leftLastDiameter){
                ring.positionY = board.leftLastSlot;
                ring.positionX = column;
                //execute
                ring.ringButton.setBounds(ring.positionX - ring.diameter / 2,
                        ring.positionY - 25, ring.diameter, 50);

                board.leftLastSlot -= 50;
                board.leftLastDiameter = ring.diameter;
                occuranceUpdate(ring, lastIndex, 250, ring.positionY);
            }
        }
    }

    public void updateRingPosition(Ring ring){
        ring.positionX = board.dictX.get(ring.index);
        ring.positionY = board.dictY.get(ring.index);

        ring.ringButton.setBounds(ring.positionX - ring.diameter / 2,
                ring.positionY - 25, ring.diameter, 50);
    }

    //method that outputs linkedList with all rings from specified column
    public LinkedList<Ring> getRingsFromColumn (String column){
        LinkedList<Ring> ringsFromColumn= new LinkedList<>();
        for (String index: board.slotOccupiance.keySet()){
            if (index.startsWith(column) && board.slotOccupiance.get(index) != null){
                ringsFromColumn.addLast(board.slotOccupiance.get(index));
            }
        }
        return ringsFromColumn;
    }

    public void updateTest(){
        ui.leftDiameter.setText("" + board.leftLastDiameter);
        ui.midDiameter.setText("" + board.middleLastDiameter);
        ui.rightDiameter.setText("" + board.rightLastDiameter);

        ui.leftAltitude.setText("" + board.leftLastSlot);
        ui.midAltitude.setText("" + board.middleLastSlot);
        ui.rightAltitude.setText("" + board.rightLastSlot);
    }

    //method that find top ring in specified column
    public Ring findTopRing(String column){
        LinkedList<Ring> ringsFromColumn = getRingsFromColumn(column);
        int topLevel = 0;
        int level = 0;
        Ring topRing = null;

        for (Ring ring : ringsFromColumn){
            if (ring.index.length() == 2) {
                level = Integer.parseInt(String.valueOf(ring.index.charAt(1)));
            }
            else if (ring.index.length() == 3) {
                //code below always set last two digits from index String
                String levelString = ring.index.substring(ring.index.length() - 2);
                level = Integer.parseInt(levelString);
            }
            if (level > topLevel){
                topLevel = level;
                topRing = ring;
            }
        }
        return topRing;
    }

    public void moveToOrSelect(int column){
        //increment switch
        move_SelectSwitch += 1;

        if (move_SelectSwitch % 2 == 0){
            moveTo(board.chosenRing, column);
        }
        else if (move_SelectSwitch % 2 == 1){
            if (column == 250){
                board.chosenRing = findTopRing("A");
            }
            else if (column == 700){
                board.chosenRing = findTopRing("B");
            }
            else if (column == 1150){
                board.chosenRing = findTopRing("C");
            }
        }
    }

    public void resetTower(){
        //deletes old RingObjects and adds new on default positions
//        main.spawn = new Spawn(main.mechanics, main.ui, main.board);

        for (String i: board.slotOccupiance.keySet()){
            //create reference to ring in that HashMap
            Ring tempRing = board.slotOccupiance.get(i);
            if (tempRing != null){
                tempRing.index = tempRing.startIndex;
                updateRingPosition(tempRing);
                board.slotOccupiance.replace(tempRing.index, tempRing);
            }
        }
        //delete every ring in column B and C
        for (String i: board.slotOccupiance.keySet()){
            if (i.charAt(0) != 'A' && board.slotOccupiance.get(i) != null){
                board.slotOccupiance.replace(i, null);
            }
        }

        board.rightLastSlot = 625;
        board.middleLastSlot = 625;
        board.rightLastDiameter = 450;
        board.middleLastDiameter = 450;
    }
}
