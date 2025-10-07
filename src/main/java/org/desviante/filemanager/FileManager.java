package org.desviante.filemanager;

import java.io.File;

public class FileManager {
    public void listContents(String directoryPath){
        File directory = new File(directoryPath);
        if (directory.exists() && directory.isDirectory()){
            File[] contents = directory.listFiles();

            if (contents != null){
                for (File content : contents){
                    if (content.isDirectory()){
                        System.out.println("[DIR]: "+content.getName());
                    } else {
                        System.out.println("[FILE]: "+content.getName());
                    }
                }
            } else {
                System.out.println("Directory is empty.");
            }
        } else{
            System.out.println("Invalid directory: Path either does not exist or is not a directory.");
        }
    }
    public void createDirectory(String directoryPath){
        File directory = new File (directoryPath);
        if (directory.mkdir()){
            System.out.println("Directory created successfully.");
        } else {
            System.out.println("Failed to create directory.");
        };
    };
    public void deleteFileOrDirectory(String directoryOrFilePath){
        File file = new File(directoryOrFilePath);
        if (file.delete()){
            System.out.println("File or directory deleted successfully.");
        } else {
            System.out.println("Failed to delete file or directory.");
        };
    }
}
