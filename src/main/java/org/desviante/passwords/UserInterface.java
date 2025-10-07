package org.desviante.passwords;

public interface UserInterface {
    public int getPasswordLength();
    public boolean useLowerCase();
    public boolean useUpperCase();
    public boolean useNumbers();
    public boolean useSpecialCharacters();
    public void displayPassword(String password);
}
