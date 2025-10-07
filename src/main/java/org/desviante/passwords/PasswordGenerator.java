package org.desviante.passwords;

import java.util.Random;

public class PasswordGenerator {
    String generatePassword(int length, boolean useLowerCase, boolean useUpercase,
                            boolean useNumbers, boolean useSpecialCharacters){
        String lowerCaseCharacters = "abcdefghijklmnopqrstuvwxyz";
        String upperCaseCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String specialCharacters = "!@#$%^&*()";

        StringBuilder charOptions = new StringBuilder();
        if (useLowerCase){
            charOptions.append(lowerCaseCharacters);
        }

        if (useUpercase){
            charOptions.append(upperCaseCharacters);
        }

        if (useNumbers){
            charOptions.append(numbers);
        }

        if (useSpecialCharacters){
            charOptions.append(specialCharacters);
        }

        String allChars = charOptions.toString();

        StringBuilder password = new StringBuilder();
        Random rand = new Random();

        for (int i = 0; i < length; i++){
            char nextLetter = allChars.charAt(new Random().nextInt(allChars.length()));
            password.append(nextLetter);
        }

        return password.toString();
    }
}
