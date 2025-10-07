package org.desviante.passwords;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TextBasedInterface implements UserInterface {
    private Scanner scanner;

    public TextBasedInterface(){
        this.scanner = new Scanner(System.in);
    }

    @Override
    public int getPasswordLength() {
        boolean invalidNumber = true;
        int length = 0;

        do{
            try{
                System.out.print("Please, enter the password length (minimum size: 4): ");
                length = scanner.nextInt();
                if (length>3) {
                    invalidNumber = false;
                }
                else {
                    System.out.println("The length must be greater than tree. Try Again.");
                    scanner.nextLine(); // Limpa o buffer
                }
            } catch (InputMismatchException e){
                System.out.println("That is not a valid number. Try Again.");
                scanner.nextLine(); // Limpa o buffer do scanner
            }
        } while(invalidNumber);
        return length;
    }

    @Override
    public boolean useLowerCase() {
        System.out.print("Would you like the password to have Lower Case letters? (y/n): ");
        return scanner.next().equalsIgnoreCase("y");
    }

    @Override
    public boolean useUpperCase() {
        System.out.print("Would you like the password to have Upper Case letters? (y/n): ");
        return scanner.next().equalsIgnoreCase("y");
    }

    @Override
    public boolean useNumbers() {
        System.out.print("Would you like the password to have Numerical Characters? (y/n): ");
        return scanner.next().equalsIgnoreCase("y");
    }

    @Override
    public boolean useSpecialCharacters() {
        System.out.print("Would you like the password to have Symbol Characters? (y/n): ");
        return scanner.next().equalsIgnoreCase("y");
    }

    @Override
    public void displayPassword(String password) {
        System.out.println("Here is the password: "+password);
    }
}
