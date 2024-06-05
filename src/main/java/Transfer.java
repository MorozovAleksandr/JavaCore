package main.java;

import main.java.interfaces.BankAccount;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transfer {
    private final String formatDateTime = "dd.MM.yyyy-HH:mm:ss";
    private String date;
    private String fileName;
    private Object fromAcc;
    private Object toAcc;
    private int transferAmount;
    private String transferResult;
    private boolean isSuccess;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Object getFromAcc() {
        return fromAcc;
    }

    public void setFromAcc(Object fromAcc) {
        this.fromAcc = fromAcc;
    }

    public Object getToAcc() {
        return toAcc;
    }

    public void setToAcc(Object toAcc) {
        this.toAcc = toAcc;
    }

    public int getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(int transferAmount) {
        this.transferAmount = transferAmount;
    }

    public String getTransferResult() {
        return transferResult;
    }

    public void setTransferResult(String transferResult) {
        this.transferResult = transferResult;
    }

    public Transfer(String fileName, Object fromAcc, Object toAcc, int transferAmount) {
        this.fileName = fileName;
        this.fromAcc = fromAcc;
        this.toAcc = toAcc;
        this.transferAmount = transferAmount;
        handleDateTime();
        handleResultAndUpdAccounts();
    }

    private void handleDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatDateTime);
        String formattedDateTime = now.format(formatter);
        setDate(formattedDateTime);
    }

    private void handleResultAndUpdAccounts() {
        StringBuilder result = new StringBuilder();
        if (fromAcc.getClass() == Account.class && toAcc.getClass() == Account.class && transferAmount > 0) {
            BankAccount currentFromAcc = (BankAccount) fromAcc;
            BankAccount currentToAcc = (BankAccount) toAcc;

            if (currentFromAcc.getBalance() >= transferAmount) {
                currentFromAcc.setBalance(currentFromAcc.getBalance() - transferAmount);
                currentToAcc.setBalance(currentToAcc.getBalance() + transferAmount);
                result.append("Успешно обработан");
                this.isSuccess = true;

            } else {
                result.append("Недостаточно средств");
                this.isSuccess = false;
            }

            setTransferResult(result.toString());
            return;
        }

        if (fromAcc.getClass() != Account.class) {
            result.append("Невалидный счет отправителя;");
        }

        if (toAcc.getClass() != Account.class) {
            result.append("Невалидный счет получателя;");
        }

        if (transferAmount < 0) {
            result.append("Неверная сумма перевода;");
        }

        setTransferResult(result.toString());
    }

    @Override
    public String toString() {
        // TODO: Проверить счета(fromAcc, toAcc) на тип, и в зависимости выводить данные
        return date + "|" + fileName + "|" + "Перевод с " + fromAcc + " на " + toAcc + " " + transferAmount + "|" + transferResult;
    }

}
