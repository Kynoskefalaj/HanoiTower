package root;

import rings.*;

public class Spawn {
    Ring ring_400, ring_350, ring_300, ring_250, ring_200, ring_150, ring_100, ring_50;
    Mechanics mechanics;
    UserInterface ui;
    Board board = new Board();
    public Spawn (Mechanics mechanics, UserInterface ui) {
        this.mechanics = mechanics;
        this.ui = ui;

        ring_400 = new Ring_400(mechanics, board);
        ui.con.add(ring_400.ringButton);

        ring_350 = new Ring_350(mechanics, board);
        ui.con.add(ring_350.ringButton);

        ring_300 = new Ring_300(mechanics, board);
        ui.con.add(ring_300.ringButton);

        ring_250 = new Ring_250(mechanics, board);
        ui.con.add(ring_250.ringButton);

        ring_200 = new Ring_200(mechanics, board);
        ui.con.add(ring_200.ringButton);

        ring_150 = new Ring_150(mechanics, board);
        ui.con.add(ring_150.ringButton);

        ring_100 = new Ring_100(mechanics, board);
        ui.con.add(ring_100.ringButton);

    }

}
