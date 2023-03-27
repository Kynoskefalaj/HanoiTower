package root;

import rings.Ring;
import rings.Ring_100;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    UniversalHandler handler = new UniversalHandler();

    public UserInterface ui;
    public Board board;
    public Mechanics mechanics;
    public Spawn spawn;
    public AI ai;

//    public Execute execute;


    public static void main(String[] args) {
        new Main();
    }

    public Main(){
        this.ui = new UserInterface(this);
        this.board = new Board();
        this.mechanics = new Mechanics(this, ui, board);
        this.spawn = new Spawn(mechanics, ui, board);
        this.ai = new AI(mechanics, board, spawn);
//        this.execute = new Execute(mechanics, spawn);
    }

    public class UniversalHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            String chosenRingName = event.getActionCommand();

            switch (chosenRingName) {
                case "400": board.chosenRing = spawn.ring_400; break;
                case "350": board.chosenRing = spawn.ring_350; break;
                case "300": board.chosenRing = spawn.ring_300; break;
                case "250": board.chosenRing = spawn.ring_250; break;
                case "200": board.chosenRing = spawn.ring_200; break;
                case "150": board.chosenRing = spawn.ring_150; break;
                case "100": board.chosenRing = spawn.ring_100; break;
                case "50": board.chosenRing = spawn.ring_50; break;
                case "LEFT":
                    mechanics.moveTo(board.chosenRing, 250);
//                    mechanics.moveToOrSelect(250);
                    mechanics.updateTest();
                    break;

                case "MIDDLE":
                    mechanics.moveTo(board.chosenRing, 700);
//                    mechanics.moveToOrSelect(700);
                    mechanics.updateTest();
                    break;

                case "RIGHT":
                    mechanics.moveTo(board.chosenRing, 1150);
//                    mechanics.moveToOrSelect(1150);
                    mechanics.updateTest();
                    break;

                case "MOVE":
                    ai.move();
                    ai.hintButtonClickCounter += 1;

                    break;
            }
        }
    }
}
