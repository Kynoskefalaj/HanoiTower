package root;

import rings.Ring;

import java.util.HashMap;


public class Board {
    String[][] index;
    public final int[] addressX = {250, 700, 1150};
    public int[] addressY = new int[12];
    public HashMap<String, Integer> dictX;
    public HashMap<String, Integer> dictY;
    public HashMap<String, Ring> slotOccupiance;


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
        // level 0 - 625 to 11 - 75 in addressY[]
        int y = 625;
        for (int i = 0; i < 12; i++){
            addressY[i] = y;
            y -= 50;
        }

        // creating dictionary with index as key and X coordinates as value
        // e.g. key: "A1" value: 1150
        dictX = new HashMap<String, Integer>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                dictX.put(index[i][j], addressX[j]);
            }
        }

        // creating dictionary with index as key and Y coordinates as value
        // e.g. key: "A2" value: 625
        dictY = new HashMap<String, Integer>();
        int k = 0;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                dictY.put(index[i][j], addressY[11 - k]);
            }
            k ++;
        }

        // initiates occupied stacks
        slotOccupiance = new HashMap<String, Ring>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                slotOccupiance.put(index[i][j], null);
            }
        }



    }


}
