package org.desviante.passwords;

import java.util.Scanner;

public class TextBasedInterface implements UserInterface {
    private Scanner scanner;

    public TextBasedInterface(){
        this.scanner = new Scanner(System.in);
    }

    @Override
    public int getPasswordLength() {
        System.out.print("Please, enter the password length: ");
        return scanner.nextInt();
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
