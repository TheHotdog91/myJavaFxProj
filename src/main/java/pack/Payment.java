package pack;

import java.util.Date;

public class Payment extends  Document {
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

    public String getEmployee() {
        return employee;
    }

    // Constructors, getters, and setters
}
