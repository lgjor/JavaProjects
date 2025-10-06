package org.desviante.wordgame;

import java.util.Random;
import java.util.Scanner;

public class WordGuessingGame {
    private String wordToGuess;
    private char[] guessedLetters;
    private int attempts;
    private String[] wordList;
    private int maxAttempts;
    private Random rand;
    
    public WordGuessingGame(String[] wordList, int maxAttempts){
        this.wordList = wordList;
        this.maxAttempts = maxAttempts;
        this.rand = new Random();
        initializeGame();
    }
    
    private void initializeGame(){
        this.wordToGuess = wordList[rand.nextInt(wordList.length)];
        this.guessedLetters = new char[wordToGuess.length()];
        for (int i=0; i<this.guessedLetters.length; i++){
            this.guessedLetters[i] = '_';
        }
        this.attempts = maxAttempts;
    }
    
    public void reset(){
        initializeGame();
    }

    public String play(){

        Scanner scanner = new Scanner(System.in);
        while (attempts > 0) {

            displayState();
            System.out.println("You have "+attempts+ "attempts left");
            System.out.print("Guess a letter: ");

            char guess = scanner.nextLine().toLowerCase().charAt(0);

            if (processGuess(guess)) {
                System.out.println("Correct!.");
                if (new String(guessedLetters).equals(wordToGuess)){
                    System.out.println("You have guessed the word. You Win!");
                    return "Win";
                }
            } else {
                System.out.println("That guess was incorrect.");
                attempts--;
            }
        }
        return "Loss";
    }

    private boolean processGuess(char letter){
        boolean letterFound = false;
        for (int i=0; i<wordToGuess.length(); i++){
            if (wordToGuess.charAt(i)==letter){
                guessedLetters[i] = letter;
                letterFound = true;
            }
        }
        return letterFound;
    }

    private void displayState(){
        System.out.println("Guessed Letters: "+new String(guessedLetters));
    }

}
