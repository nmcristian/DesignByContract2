package designbycontract2;

import java.util.ArrayList;

public class Customer {

    private static Long idGen = (long) 0;
    private Long id;
    private String name;
    private ArrayList<Account> accounts;
    private final Bank bank;

    public Customer(String name, Bank b) {
        this.id = ++idGen;
        this.name = name;
        this.bank = b;
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Boolean addAccount(Account acc) {
        return accounts.add(acc);
    }

    public Account getAccountById(Long bankId) {
        for (Account a : accounts) {
            if (a.getId() == bankId) {
                return a;
            }
        }
        return null;
    }
}
