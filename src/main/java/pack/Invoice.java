package pack;

import java.time.LocalDate;
import java.util.Date;

public class Invoice extends Document {


    private String number;
    private LocalDate date;
    private String user;
    private double amount;
    private String currency;
    private double exchangeRate;
    private String product;
    private double quantity;

    public void setNumber(String s) {
        this.number = s;
    }
    public String getNumber() {
        return number;
    }
    public String getProduct() {
        return this.product;
    }

    @Override
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setUser(String text) {
    }

    public void setAmount(double v) {
    }

    public void setCurrency(String text) {
    }

    public void setExchangeRate(double v) {
    }

    public void setProduct(String text) {
    }

    public void setQuantity(double v) {
    }

    // Constructors, getters, and setters
}
