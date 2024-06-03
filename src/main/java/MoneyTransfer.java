package main.java;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

public class MoneyTransfer {
    private static final int PARSE_CODE = 1;
    private static final int OUTPUT_CODE = 2;
    private static final String OPERATION_NOT_FOUND = "Такой операции не существует";
    private static final String INPUT_FILES_PATH = "src/main/resources/data/input";
    private static final String ACCOUNTS_FILE_PATH = "src/main/resources/data/accounts.txt";
    private static final String ACCOUNT_PATTERN = "\\d{5}-\\d{5}";
    private static final String ACCOUNTS_SEPARATOR = "\\|";
    private static final Map<String, Account> accounts = new HashMap<>();

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
        getAccounts();
        getTransfers();
    }

    // Получение переводов из файла
    private static void getTransfers() {
        FileWorker fileWorker = new FileWorker();
        List<String> fileLines = fileWorker.getParsedInputFiles(INPUT_FILES_PATH);
    }

    // Получение списка счетов из файла
    private static void getAccounts() {
        FileWorker fileWorker = new FileWorker();
        List<String> accountsList = fileWorker.getParsedAccountsFile(ACCOUNTS_FILE_PATH);
        Consumer<String> createAcc = str -> {
            String[] values = str.split(ACCOUNTS_SEPARATOR);
            if (values.length == 2 && values[0].matches(ACCOUNT_PATTERN)) {
                accounts.put(values[0], new Account(values[0], Integer.parseInt(values[1])));
            }
        };

        accountsList.forEach(createAcc);
    }

    private static void output() {
        System.out.println("OUTPUT");
    }
}
