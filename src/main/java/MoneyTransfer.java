package main.java;

import java.util.List;
import java.util.Scanner;

public class MoneyTransfer {
    private static final int PARSE_CODE = 1;
    private static final int OUTPUT_CODE = 2;
    private static final String OPERATION_NOT_FOUND = "Такой операции не существует";
    private static final String INPUT_FILES_PATH = "src/main/resources/data/input";

    public static void startTransfer() {
        System.out.print("Введите номер операции (1,2): ");
        Scanner scanner = new Scanner(System.in);
        int operationsCode = scanner.nextInt();
        scanner.close();

        switch (operationsCode) {
            case PARSE_CODE -> parse();
            case OUTPUT_CODE -> output();
            default -> System.out.println(OPERATION_NOT_FOUND);
        }
    }

    private static void parse() {
        FileWorker fileWorker = new FileWorker();
        List<String> fileLines = fileWorker.getParsedFiles(INPUT_FILES_PATH);

        System.out.println(fileLines);
    }

    private static void output() {
        System.out.println("OUTPUT");
    }
}
