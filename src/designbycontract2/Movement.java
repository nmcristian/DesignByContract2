package designbycontract2;

import java.util.Date;

public class Movement {

    private static Long idGen = (long) 0;
    private Long id;
    private Date date;
    private double amount;
    private Account source, target;

    public Movement(Date date, double amount, Account source, Account target) {
        this.id = ++idGen;
        this.date = date;
        this.amount = amount;
        this.source = source;
        this.target = target;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }
}
