package org.desviante.filemanager;

public class FileApp implements UIEventHandler {
    private final FileManager fm;

    public FileApp (){
        FileManager fm = new FileManager();
        this.fm = fm;
    }

    @Override
    public void onList(String path) {
        this.fm.listContents(path);
    }

    @Override
    public void onCreate(String path) {
        this.fm.createDirectory(path);
    }

    @Override
    public void onDelete(String path) {
        this.fm.deleteFileOrDirectory(path);
    }

    public static void main(String[] args) {
        UserInterface ui = new TextBasedInterface();
        ui.subscribe(new FileApp());
        ui.start();
    }
}
