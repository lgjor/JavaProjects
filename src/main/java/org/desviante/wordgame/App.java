package org.desviante.wordgame;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String[] words = {"java", "computer", "banana", "futebol", "cinema"};
        WordGuessingGame game = new WordGuessingGame(words, 10);

        try (Scanner scanner = new Scanner(System.in)) {
            boolean shouldPlayAgain = false;

            int wins = 0;
            int losses = 0;

            do{
                String result = game.play();
                if (result.equals("Win")){
                    wins++;
                }
                else {
                    losses++;
                }

                System.out.println("Wins: " + wins + ", Losses: " + losses);

                System.out.print("Would you like to play again? (y/n): ");
                char playAgain = scanner.nextLine().toLowerCase().charAt(0);
                shouldPlayAgain = playAgain == 'y';
                
                if (shouldPlayAgain) {
                    game.reset();
                }

            } while(shouldPlayAgain);
        }

    }
}
