package main.java;

import java.time.LocalDateTime;

public class Transfer<T, K> {
    private LocalDateTime date;
    private String fileName;
    private T fromAcc;
    private K toAcc;
    private int transferAmount;
    private String transferResult;

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public T getFromAcc() {
        return fromAcc;
    }

    public void setFromAcc(T fromAcc) {
        this.fromAcc = fromAcc;
    }

    public K getToAcc() {
        return toAcc;
    }

    public void setToAcc(K toAcc) {
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

    public Transfer(LocalDateTime date, String fileName, T fromAcc, K toAcc, int transferAmount, String transferResult) {
        this.date = date;
        this.fileName = fileName;
        this.fromAcc = fromAcc;
        this.toAcc = toAcc;
        this.transferAmount = transferAmount;
        this.transferResult = transferResult;
    }

    @Override
    public String toString() {
        // TODO: Проверить счета(fromAcc, toAcc) на тип, и в зависимости выводить данные
        return date + "|" + fileName + "|" + "Перевод с " + fromAcc + " на " + toAcc + " " + transferAmount + "|" + transferResult;
    }
}
