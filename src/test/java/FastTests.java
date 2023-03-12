import java.util.LinkedList;

public class FastTests {

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

        LinkedList<String> leftColumnIndex = new LinkedList<String>();

        for (int j = 0; j < 11; j++) {
            for (int i = 0; i < 3; i++) {
                System.out.print(index[j][i] + " ");
            }
            System.out.println();
        }
    }
}
