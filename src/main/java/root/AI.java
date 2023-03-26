package root;

import rings.Ring;

import java.util.LinkedList;
import java.util.Objects;

public class AI {
    public Mechanics mechanics;
    public Board board;
    public Spawn s;
    String[] oddMovesAlgorithm = {"AB", "AC", "BC"};
    String[] evenMovesAlgorithm = {"AC", "AB", "BC"};

    public AI(Mechanics mechanics, Board board, Spawn s){
        this.mechanics = mechanics;
        this.board = board;
        this.s = s;
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
            switch (newColumn) {
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
//    public void move()

}
