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

    public int leftLastSlot, middleLastSlot = 625, rightLastSlot = 625;
    public int leftLastDiameter, middleLastDiameter = 450, rightLastDiameter = 450;

    public Ring chosenRing;

    public Board () {
        index = new String[][]{
                {"A12", "B12", "C12"},
                {"A11", "B11", "C11"},
                {"A10", "B10", "C10"},
                {"A9",  "B9" , "C9" },
                {"A8",  "B8" , "C8" },
                {"A7",  "B7" , "C7" },
                {"A6",  "B6" , "C6" },
                {"A5",  "B5" , "C5" },
                {"A4",  "B4" , "C4" },
                {"A3",  "B3" , "C3" },
                {"A2",  "B2" , "C2" },
                {"A1",  "B1" , "C1" },
        };

        // give values to particular levels from
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
