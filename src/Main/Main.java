package Main;

import UI.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        newMap();
    }

    public static void newMap() {
        Map mappa = new Map();

        mappa.display_on_out();

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter row: ");
            Scanner myObj = new Scanner(System.in);
            int row = myObj.nextInt();

            System.out.print("Enter column: ");
            int col = myObj.nextInt();

            System.out.println("Changing: "+row+" - "+col);
            mappa.insert_at_coords(row, col, 'S');
            System.out.println();
            mappa.display_on_out();
        }
    }
}
