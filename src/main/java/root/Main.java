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
//    public Execute execute;


    public static void main(String[] args) {
        new Main();
    }

    public Main(){
        this.ui = new UserInterface(this);
        this.board = new Board();
        this.mechanics = new Mechanics(this, ui, board);
        this.spawn = new Spawn(mechanics, ui, board);
//        this.execute = new Execute(mechanics, spawn);
    }

    public class UniversalHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            String chosenRingName = event.getActionCommand();

            switch (chosenRingName) {
                case "400": break;
                case "350": break;
                case "300": break;
                case "250": break;
                case "200": break;
                case "150": break;
                case "100": board.chosenRing = spawn.ring_100; break;
                case "50": break;
                case "LEFT": mechanics.moveTo(board.chosenRing, 250); break;
                case "MIDDLE": mechanics.moveTo(board.chosenRing, 700); break;
                case "RIGHT": mechanics.moveTo(board.chosenRing, 1150); break;
            }
        }
    }
}
