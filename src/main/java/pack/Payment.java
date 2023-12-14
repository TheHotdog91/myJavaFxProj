package pack;

import java.util.Date;

public class Payment {
    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    private String number;
    private Date date;
    private String user;
    private double amount;
    private String employee;

    // Constructors, getters, and setters
}
