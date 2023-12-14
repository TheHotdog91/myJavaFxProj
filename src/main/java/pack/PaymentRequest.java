package pack;

import java.time.LocalDate;
import java.util.Date;

public class PaymentRequest extends  Document{
//    public String getNumber() {
//        return number;
//    }

    private String number;

    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public LocalDate getDate() {
        return date;
    }

    @Override
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String getUser() {
        return user;
    }

    @Override
    public void setUser(String user) {
        this.user = user;
    }

    public String getCounterparty() {
        return counterparty;
    }

    public void setCounterparty(String counterparty) {
        this.counterparty = counterparty;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    private LocalDate date;
    private String user;
    private String counterparty;
    private double amount;
    private String currency;
    private double exchangeRate;
    private double commission;

//    public void setNumber(String number) {
//        this.number = number;
//    }
//
//    public String getCounterparty() {
//        return counterparty;
//    }

    // Constructors, getters, and setters
}
