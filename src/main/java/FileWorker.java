package main.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWorker {
    public File[] readFiles(String path) {
        File directory = new File(path);

        return directory.listFiles((dir, name) -> name.endsWith(".txt"));
    }

    public List<String> getParsedFiles(String path) {
        File[] files = readFiles(path);
        List<String> fileLines = new ArrayList<>();

        for (File file : files) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    fileLines.add(line);
                }
            } catch (IOException e) {
                System.out.println("Произощла ошибка при чтении файлов: " + e);
            }
        }

        return fileLines;
    }
}
