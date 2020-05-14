package sender;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Scanner;

public class DefaultFileLinesReader implements FileLinesReader {
    String defaultFile;

    public DefaultFileLinesReader(String defaultFile) {
        this.defaultFile = defaultFile;
    }

    protected List<String> fileScanner(String file) {
        List<String> fileScannerList = null;

        if(scannerInput().equals("y")) {
            try {
                fileScannerList = Files.readAllLines(getPaths(file));
            }
            catch(IOException ex) {
                throw new RuntimeException("Default file not defined!", ex); //default file must exist in MessageSender folder
            }
        }
        else
            throw new RuntimeException("No file selected."); //default file must exist in MessageSender folder

        return fileScannerList;
    }

    protected Path getPaths(String file) {
        try {
            return Paths.get(file);
        }
        catch(FileSystemNotFoundException e) {
            throw new RuntimeException("Default file not defined!", e); //default file must exist in MessageSender folder
        }
    }

    protected String scannerInput() {
        try(Scanner input = new Scanner(System.in)) {
            return input.next();
        }
    }

    @Override
    public List<String> readAllLines(String filename) {
        List<String> linesOutput;

        try {
            linesOutput = Files.readAllLines(Paths.get(filename));
        }
        catch(IOException e) {
            System.err.println("Provided file: \"" + filename + "\" does not exist. Default file: " + defaultFile + "\n");
            e.printStackTrace();
            System.err.println("Do you want to use default file? [y/n]");

            linesOutput = fileScanner(defaultFile);
        }
        return linesOutput;
    }
}
