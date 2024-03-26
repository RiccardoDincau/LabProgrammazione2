package Main;

import data.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        newMap();
    }

    public static void newMap() throws InterruptedException {
        Map mappa = new Map();

        int numOfAttempts = (int)(50 + Math.random() * 30);

        for (int i = 0; i < numOfAttempts; i++) {
            mappa.insert_at_coords(0, (int)(Math.random() * mappa.getColonne()));
            mappa.display_on_out();
            Thread.sleep(100);
        }
        mappa.display_on_out();
    }
}
