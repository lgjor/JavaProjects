package org.desviante.passwords;

import java.util.Random;

public class PasswordGenerator {
    public String generatePassword(int length, boolean useLowerCase, boolean useUpperCase,
                                boolean useNumbers, boolean useSpecialCharacters) {
        String lowerCaseCharacters = "abcdefghijklmnopqrstuvwxyz";
        String upperCaseCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String specialCharacters = "!@#$%^&*()";

        Random rand = new Random();
        StringBuilder password = new StringBuilder();
        
        // ETAPA 1: Garantir pelo menos 1 de cada tipo selecionado
        if (useLowerCase) {
            password.append(lowerCaseCharacters.charAt(rand.nextInt(lowerCaseCharacters.length())));
        }
        if (useUpperCase) {
            password.append(upperCaseCharacters.charAt(rand.nextInt(upperCaseCharacters.length())));
        }
        if (useNumbers) {
            password.append(numbers.charAt(rand.nextInt(numbers.length())));
        }
        if (useSpecialCharacters) {
            password.append(specialCharacters.charAt(rand.nextInt(specialCharacters.length())));
        }
        
        // ETAPA 2: Preencher o restante com caracteres aleatórios
        StringBuilder allChars = new StringBuilder();
        if (useLowerCase) allChars.append(lowerCaseCharacters);
        if (useUpperCase) allChars.append(upperCaseCharacters);
        if (useNumbers) allChars.append(numbers);
        if (useSpecialCharacters) allChars.append(specialCharacters);
        
        int remainingLength = length - password.length();
        for (int i = 0; i < remainingLength; i++) {
            password.append(allChars.charAt(rand.nextInt(allChars.length())));
        }
    
        // ETAPA 3: Embaralhar para randomizar as posições
        return shuffleString(password.toString(), rand);
    }

    private String shuffleString(String input, Random rand) {
        char[] characters = input.toCharArray();
        for (int i = characters.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            char temp = characters[i];
            characters[i] = characters[j];
            characters[j] = temp;
        }
        return new String(characters);
    }
}