package org.desviante.dice;

import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * Entry point for our dice roller simulator.
 */
public class Simulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean appCompleted = false;

        do{
            try{
                System.out.print("How many dices would you like to roll? ");
                int dices = scanner.nextInt();
                if (dices<=0){
                    throw new InputMismatchException();
                }
                Random rand = new Random();
                System.out.println("About to roll "+ dices + " dices");
                for (int i=0; i<dices; i++){
                    int rolledNumber = rand.nextInt(6)+ 1;
                    System.out.println(display(rolledNumber));
                }
                appCompleted = true;
            } catch (InputMismatchException e){
                System.out.println("That is not a valid number of dices to roll");
                scanner.nextLine(); //Limpa o scanner caso valor inválido tenha sido inserido
            }
        } while (!appCompleted);
        scanner.close();
    }

    static String display(int value){
        return switch (value) {
            case 1 -> "---------\n|       |\n|   o   |\n|       |\n---------";
            case 2 -> "---------\n|   o   |\n|       |\n|   o   |\n---------";
            case 3 -> "---------\n| o     |\n|   o   |\n|     o |\n---------";
            case 4 -> "---------\n| o   o |\n|       |\n| o   o |\n---------";
            case 5 -> "---------\n| o   o |\n|   o   |\n| o   o |\n---------";
            case 6 -> "---------\n| o   o |\n| o   o |\n| o   o |\n---------";
            default -> "Not a valid dice value";
        };

    }

}
