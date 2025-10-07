package org.desviante.passwords;

public class App {
    public static void main(String[] args) {
        UserInterface ui = new TextBasedInterface();

        int length = ui.getPasswordLength();

        boolean useLowerCase = ui.useLowerCase();
        boolean useUpperCase = ui.useUpperCase();
        boolean useNumbers = ui.useNumbers();
        boolean useSpecialCharacters = ui.useSpecialCharacters();

        PasswordGenerator gen = new PasswordGenerator();
        String password = gen.generatePassword(length, useLowerCase, useUpperCase, useNumbers, useSpecialCharacters);
        ui.displayPassword(password);
    }
}
