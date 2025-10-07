package org.desviante.filemanager;

import java.util.Scanner;

public class TextBasedInterface implements UserInterface {
    private UIEventHandler handler = null;

    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("----------------------");
            System.out.println("File manager menu:");
            System.out.println("1. List contents");
            System.out.println("2. Create a directory");
            System.out.println("3. Delete a file or directory");
            System.out.println("4. Exit program");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    System.out.println("Enter directory path: ");
                    System.out.println("----------------------");
                    handler.onList(scanner.nextLine());
                    break;
                }
                case 2: {
                    System.out.print("Entender directory path: ");
                    System.out.println("----------------------");
                    handler.onCreate(scanner.nextLine());

                    break;
                }
                case 3: {
                    System.out.println("Enter file or directory path: ");
                    System.out.println("----------------------");
                    handler.onDelete(scanner.nextLine());
                    break;
                }
                case 4: {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                default: {
                    System.out.println("Invalid choice. Try again.");
                    break;
                }
            }
        }
    }

    @Override
    public void subscribe(UIEventHandler handler) {
        if (this.handler == null){
            this.handler = handler;
        }
    }

    @Override
    public void display(String message) {
        System.out.println(message);
    }
}
