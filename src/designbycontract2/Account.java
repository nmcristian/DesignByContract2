package designbycontract2;

import java.util.ArrayList;
import java.util.Date;

public class Account {

    private static Long idGen;
    private Long id;
    private double balance;
    private ArrayList<Movement> credits, debits;
    private final Bank bank;
    private final Customer owner;

    public Account(Bank b, Customer c) {
        this.bank = b;
        this.owner = c;
        this.id = ++idGen;
        this.balance = 0;
        this.credits = new ArrayList<>();
        this.debits = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public Movement saveCredit(Double d, Account from) {
        Movement m = new Movement(new Date(), d, from, this);
        this.credits.add(m);
        this.balance += m.getAmount();
        return m;
    }

    public Movement saveDebit(Double d, Account to) {
        Movement m = new Movement(new Date(), d, this, to);
        this.debits.add(m);
        this.balance -= m.getAmount();
        return m;
    }

    public ArrayList<Movement> getCredits() {
        return credits;
    }

    public ArrayList<Movement> getDebits() {
        return debits;
    }
}