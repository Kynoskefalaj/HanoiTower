package root;

import rings.Ring;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Objects;

public class AI {
    public Mechanics mechanics;
    public Board board;
    public Spawn s;
    String[] oddMovesAlgorithm = {"AC", "AB", "BC"};
    String[] evenMovesAlgorithm = {"AB", "AC", "BC"};

    public int moveCounter = 0;
    Timer timer;

    public int hintButtonClickCounter = 0;

    public AI(Mechanics mechanics, Board board, Spawn s){
        this.mechanics = mechanics;
        this.board = board;
        this.s = s;

        oddOrEvenHeight();
    }


    //method that checks possible move between two specified columns
    public boolean isMovePossible(String oldColumn, String newColumn){
        Ring movedRing;
        Ring coveredRing;
        LinkedList<Ring> comparedRings= new LinkedList<>();

        //find top ring in oldColumn
        movedRing = mechanics.findTopRing(oldColumn);
        //find top ring in newColumn
        coveredRing = mechanics.findTopRing(newColumn);
        if (coveredRing == null){
            return true;
        }

        if (movedRing == null){
            return false;
        }
        //compare its diameters and return true if ring from oldColumn is smaller then other
        return movedRing.diameter < coveredRing.diameter;
    }

    //method that execute move between two columns
    public void moveBetweenColumns(String oldColumn, String newColumn){
        //check if it is possible to execute move
        if (isMovePossible(oldColumn, newColumn)){
            board.chosenRing = mechanics.findTopRing(oldColumn);
            switch (newColumn) {
                case "A" -> mechanics.moveTo(board.chosenRing, 250);
                case "B" -> mechanics.moveTo(board.chosenRing, 700);
                case "C" -> mechanics.moveTo(board.chosenRing, 1150);
            }
        } else if (isMovePossible(newColumn, oldColumn)){
            board.chosenRing = mechanics.findTopRing(newColumn);
            switch (oldColumn) {
                case "A" -> mechanics.moveTo(board.chosenRing, 250);
                case "B" -> mechanics.moveTo(board.chosenRing, 700);
                case "C" -> mechanics.moveTo(board.chosenRing, 1150);
            }
        }
    }

    //method which checks height of tower and set values in Board class
    //if its odd or even
    public void oddOrEvenHeight(){
        int count = 0;
        for (String i: board.slotOccupiance.keySet()){
            if (board.slotOccupiance.get(i) != null){
                count += 1;
            }
        }
        board.towerHeight = count;

        if (count % 2 == 0){
            board.towerHeightOddOrEven = "even";
        } else
            board.towerHeightOddOrEven = "odd";
    }

    //method that input column names and execute move
    public void move(){
        if (Objects.equals(board.towerHeightOddOrEven, "even")){
            String firstColumn = String.valueOf(evenMovesAlgorithm[moveCounter].charAt(0));
            String secondColumn = String.valueOf(evenMovesAlgorithm[moveCounter].charAt(1));

            switch (moveCounter) {
                case 0 -> {moveBetweenColumns(firstColumn, secondColumn); moveCounter = 1;}
                case 1 -> {moveBetweenColumns(firstColumn, secondColumn); moveCounter = 2;}
                case 2 -> {moveBetweenColumns(firstColumn, secondColumn); moveCounter = 0;}
            }
        }
        else if (Objects.equals(board.towerHeightOddOrEven, "odd")){
            String firstColumn = String.valueOf(oddMovesAlgorithm[moveCounter].charAt(0));
            String secondColumn = String.valueOf(oddMovesAlgorithm[moveCounter].charAt(1));

            switch (moveCounter) {
                case 0 -> {moveBetweenColumns(firstColumn, secondColumn); moveCounter = 1;}
                case 1 -> {moveBetweenColumns(firstColumn, secondColumn); moveCounter = 2;}
                case 2 -> {moveBetweenColumns(firstColumn, secondColumn); moveCounter = 0;}
            }
        }
    }

    public void autoResolve() throws InterruptedException {
        timer = new Timer(35, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (!Objects.equals(s.ring_100.index, "C7")){
                    move();
                } else {
                    timer.stop();
                }
            }
        });
        timer.start();
    }

}
