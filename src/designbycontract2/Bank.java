package designbycontract2;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private String name;
    private List<Customer> customers;
    private List<Account> accounts;

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