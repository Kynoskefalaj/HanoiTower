package root;

import java.util.HashMap;
import java.util.LinkedList;

public class Board {
    String[][] index;
    public int[] addressX = {250, 700, 1150};
    public int[] addressY = new int[12];
    HashMap<String, Integer> dictX;
    HashMap<String, Integer> dictY;
    LinkedList<String> leftColumnIndex, middleColumnIndex, rightColumnIndex;

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

        leftColumnIndex = new LinkedList<String>();

        // creating dictionary with index as key and X coordinates as value
        dictX = new HashMap<String, Integer>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                dictX.put(index[i][j], addressX[j]);
            }
        }


//        for (int i = 0; i < index.length;)


        // gives values to particular levels from
        // level 0 - 625 to 11 - 75
        int y = 625;
        for (int i = 0; i < 12; i++){
            addressY[i] = y;
            y -= 50;
        }
    }


}
