package root;

import java.util.HashMap;

public class Board {
    String[][] index;
    int[] addressX = {1150, 700, 250};
    int[] addressY = new int[12];
    HashMap<String, Integer> dictX;
    HashMap<String, Integer> dictY;

    public Board () {
        index = new String[][]{
                {"L3", "L2", "L1"},
                {"K3", "K2", "K1"},
                {"J3", "J2", "J1"},
                {"I3", "I2", "I1"},
                {"H3", "H2", "H1"},
                {"G3", "G2", "G1"},
                {"F3", "F2", "F1"},
                {"E3", "E2", "E1"},
                {"D3", "D2", "D1"},
                {"C3", "C2", "C1"},
                {"B3", "B2", "B1"},
                {"A3", "A2", "A1"},
        };

        // gives values to particular levels from
        // level 0 - 625 to 11 - 75
        for (int i = 0; i < 12; i++){
            int y = 625;
            addressY[i] = y;
            y -= 50;
        }
    }


}
