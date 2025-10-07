package org.desviante.passwords;

public class App {
    public static void main(String[] args) {
        PasswordGenerator gen = new PasswordGenerator();
        System.out.println(gen.generatePassword(10, true, true, true, true));
    }
}
