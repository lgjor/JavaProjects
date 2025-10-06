package org.desviante.dice;

import java.util.Random;

/**
 * Entry point for our dice roller simulator.
 */
public class Simulator {
    public static void main(String[] args) {
        Random rand = new Random();
        int rolledNumber = rand.nextInt(6)+ 1;
        System.out.println(display(rolledNumber));
    }

    static String display(int value){
        switch (value){
            case 1:
                return "---------\n|       |\n|   o   |\n|       |\n---------";

            case 2:
                return "---------\n|   o   |\n|       |\n|   o   |\n---------";

            case 3:
                return "---------\n| o     |\n|   o   |\n|     o |\n---------";

            case 4:
                return "---------\n| o   o |\n|       |\n| o   o |\n---------";

            case 5:
                return "---------\n| o   o |\n|   o   |\n| o   o |\n---------";

            case 6:
                return "---------\n| o   o |\n| o   o |\n| o   o |\n---------";

            default:
                return "Not a valid dice value";
        }

    }

}
