package pack;

import java.util.Date;

public class Document {
    public void setNumder(String numder) {
        this.numder = numder;
    }

    public String getNumder() {
        return numder;
    }

    private String numder;
    private Date data;
    public String getNumber() {
        return this.numder;
    }

    public Object getDate() {
        return this.data;
    }
}
