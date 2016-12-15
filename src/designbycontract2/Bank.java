package designbycontract2;

import java.util.ArrayList;
import java.util.List;
import org.jmlspecs.annotation.Requires;
import org.jmlspecs.annotation.Ensures;
import org.jmlspecs.annotation.Invariant;

public class Bank {

    private String name;
    private List<Customer> customers;
    private List<Account> accounts;

//    invariant_to_be_created: sum of all accounts.balance == 0.0

    //@ assignable name;
    //@ ensures name != null;
    //@ ensures customers != null;
    //@ ensures accounts != null;
    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
        this.accounts = new ArrayList<>();
    }

    public Customer addCustomer(String name) {
        Customer c = new Customer(name, this);
        customers.add(c);
        return c;
    }

    public Boolean removeCustomer(Customer c) {
        return customers.remove(c);
    }

    public Account addAccount(Customer c) {
        Account a = new Account(this, c);
        accounts.add(a);
        return a;
    }

    public Boolean removeAccount(Account a) {
        return accounts.remove(a);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    //@ requires amount > 0;
    //@ requires source != null;
    //@ requires target != null;
    //@ requires source != target;
    //@ ensures \result == true;
    public Boolean move(double amount, Account source, Account target) {
        source.saveDebit(amount, target);
        target.saveCredit(amount, source);
        return true;
    }

    public List makeStatement(Customer cust, Long accId) {
        List transactions = cust.getAccountById(accId).getCredits();
        List debits = cust.getAccountById(accId).getDebits();
        transactions.addAll(debits);
//        do some sorting by date
        return transactions;
    }
}
