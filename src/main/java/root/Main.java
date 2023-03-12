package root;

import rings.Ring;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    Ring chosenRing;
    UniversalHandler handler = new UniversalHandler();

    public UserInterface ui;
    public Mechanics mechanics;
    public Spawn spawn;
    public Board board;

    public static void main(String[] args) {
        new Main();
    }

    public Main(){
        this.ui = new UserInterface();
        this.board = new Board();
        this.mechanics = new Mechanics(this, ui, board);
        this.spawn = new Spawn(mechanics, ui);
    }

    public class UniversalHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            String chosenRingIndex = event.getActionCommand();

            switch (chosenRingIndex) {
                case "400": break;
                case "350": break;
                case "300": break;
                case "250": break;
                case "200": break;
                case "150": break;
                case "100": break;
                case "50": break;
            }
        }
    }
}
