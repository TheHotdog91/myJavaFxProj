package pack;

import javafx.beans.binding.BooleanExpression;
import javafx.beans.value.ObservableValue;

import java.time.LocalDate;
import java.util.Date;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
public class Document {
    private String user;
    private String numder;
    private LocalDate data;
    private double amount;
    private String property;
//    public void setNumder(String numder) {
//        this.numder = numder;
//    }
//
//    public String getNumder() {
//        return numder;
//    }





    private final StringProperty numbers = new SimpleStringProperty();
    private final SimpleObjectProperty<LocalDate> dates = new SimpleObjectProperty<>();
    private final StringProperty users = new SimpleStringProperty();
    // Other methods and constructors...

    public String getNumber() {
        return numbers.get();
    }

    public void setNumber(String number) {
        this.numbers.set(number);
    }

    public StringProperty numberProperty() {
        return numbers;
    }

    public LocalDate getDate() {
        return dates.get();
    }

    public void setDate(LocalDate date) {
        this.dates.set(date);
    }

    public SimpleObjectProperty<LocalDate> dateProperty() {
        return dates;
    }


    // Other methods and constructors...
    public String getUser() {
        return users.get();
    }

    public void setUser(String user) {
        this.users.set(user);
    }
    public StringProperty userProperty() {
        return users;
    }
//    public BooleanExpression amountProperty() {
//        return (BooleanExpression) amount;
//    }
//
//    public String currencyProperty() {
//        return property;
//    }
//
//    public BooleanExpression exchangeRateProperty() {
//    }
//
//    public ObservableValue<String> productProperty() {
//    }
//
//    public BooleanExpression quantityProperty() {
//        return  f;
//    }
}
