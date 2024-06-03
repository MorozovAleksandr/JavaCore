package main.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWorker {
    private File[] readInputFiles(String path) {
        File directory = new File(path);

        return directory.listFiles((dir, name) -> name.endsWith(".txt"));
    }

    private List<String> getFileLines(File file) {
        List<String> fileLines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                fileLines.add(line);
            }
        } catch (IOException e) {
            System.out.println("Произощла ошибка при чтении файла: " + e);
        }

        return fileLines;
    }

    public List<String> getParsedInputFiles(String path) {
        File[] files = readInputFiles(path);
        List<String> AllFileLines = new ArrayList<>();

        for (File file : files) {
            AllFileLines.addAll(getFileLines(file));
        }

        return AllFileLines;
    }

    public List<String> getParsedAccountsFile(String path) {
        File file = new File(path);
        
        return getFileLines(file);
    }
}
