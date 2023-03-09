package root;

import rings.Ring_400;

public class Spawn {
    Ring_400 ring_400;
    Mechanics mechanics;
    UserInterface ui;
    public Spawn (Mechanics mechanics, UserInterface ui) {
        this.mechanics = mechanics;
        this.ui = ui;

        ring_400 = new Ring_400(mechanics, new Board());
        ui.con.add(ring_400.ringButton);

    }

}
