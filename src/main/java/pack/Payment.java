package pack;

import java.time.LocalDate;
import java.util.Date;

public class Payment extends  Document {
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }
//    public void setNumber(String number) {
//        this.number = number;
//    }
//
//    public String getNumber() {
//        return number;
//    }

    private String number;
    private LocalDate date;
    private String user;
    private double amount;
    private String employee;

    public String getEmployee() {
        return employee;
    }

    // Constructors, getters, and setters
}
