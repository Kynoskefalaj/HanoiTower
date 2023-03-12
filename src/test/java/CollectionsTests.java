import java.util.HashMap;
import java.util.LinkedList;

public class CollectionsTests {

    public static void main(String[] args) {
        String[][] index = new String[][]{
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

        int[] addressX = {250, 700, 1150};

        LinkedList<String> leftColumnIndex = new LinkedList<String>();

        for (int j = 0; j < 11; j++) {
            for (int i = 0; i < 3; i++) {
                System.out.print(index[j][i] + " ");
            }
            System.out.println();
        }
        // creating dictionary with index as key and X coordinates as value
        HashMap<String, Integer> dictX = new HashMap<String, Integer>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                dictX.put(index[i][j], addressX[j]);
            }
        }

        // looping through every key and value in dictX
        for (String i : dictX.keySet()) {
            System.out.println("key: " + i + " value: " + dictX.get(i));
        }


        // creating table with Y coordinates
        int[] addressY = new int[12];

        int y = 625;
        for (int i = 0; i < 12; i++){
            addressY[i] = y;
            y -= 50;
        }

        // creating dictionary with index as key and Y coordinates as value
        HashMap<String, Integer> dictY = new HashMap<String, Integer>();
        int k = 0;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                dictY.put(index[i][j], addressY[11 - k]);
            }
            k ++;
        }

        // looping through every key and value in dictY
        for (String i : dictY.keySet()) {
            System.out.println("key: " + i + " value: " + dictY.get(i));
        }

    }
}
