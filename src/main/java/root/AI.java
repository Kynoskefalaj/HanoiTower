package root;

import rings.Ring;

import java.util.LinkedList;

public class AI {
    public Mechanics mechanics;
    public Board board;
    public Spawn s;

    public AI(Mechanics mechanics, Board board, Spawn s){
        this.mechanics = mechanics;
        this.board = board;
        this.s = s;
    }

    //method that find top ring in specified column
    public Ring findTopRing(String column){
        LinkedList<Ring> ringsFromColumn = mechanics.getRingsFromColumn(column);
        int topLevel = 1;
        int level = 0;
        Ring topRing = null;

        for (Ring ring : ringsFromColumn){
            if (ring.index.length() == 2) {
                level = ring.index.charAt(1);
            }
            else if (ring.index.length() == 3) {
                //code below alweys set last two digits from index String
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

    //method that checks possible move between two specified columns
    public boolean isMovePossible(String oldColumn, String newColumn){
        Ring movedRing;
        Ring coveredRing;
        LinkedList<Ring> comparedRings= new LinkedList<>();

        //find top ring in oldColumn
        movedRing = findTopRing(oldColumn);
        //find top ring in newColumn
        coveredRing = findTopRing(newColumn);
        //compare its diameters and return true if ring from oldColumn is smaller then other
        return movedRing.diameter < coveredRing.diameter;
    }
    //method that execute the best possible move
    public void move(String oldColumn, String newColumn){
    }

    //method that repeats moves until the puzzle is resolved
}
