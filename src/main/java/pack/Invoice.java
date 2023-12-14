package pack;

import java.util.Date;

public class Invoice extends Document {
    public String getNumber() {
        return number;
    }

    private String number;
    private Date date;
    private String user;
    private double amount;
    private String currency;
    private double exchangeRate;
    private String product;
    private double quantity;

    public void setNumber(String s) {
        this.number = s;
    }

    public String getProduct() {
        return this.product;
    }

    // Constructors, getters, and setters
}
