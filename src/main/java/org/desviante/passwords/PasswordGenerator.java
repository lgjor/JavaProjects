package org.desviante.passwords;

import java.util.Random;

public class PasswordGenerator {
    String generatePassword(int length, boolean useLowerCase, boolean useUpercase,
                            boolean useNumbers, boolean useSpecialCharacters){
        String lowerCaseCharacters = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder password = new StringBuilder();
        Random rand = new Random();

        for (int i = 0; i < length; i++){
            char nextLetter = lowerCaseCharacters.charAt(new Random().nextInt(lowerCaseCharacters.length()));
            password.append(nextLetter);
        }

        return password.toString();
    }
}
