package pack;

import java.util.Date;

public class Invoice {
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

    // Constructors, getters, and setters
}
