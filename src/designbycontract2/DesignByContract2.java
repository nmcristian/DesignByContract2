package designbycontract2;

public class DesignByContract2 {

    public static void main(String[] args) {

        Bank b = new Bank("Nordea");
        Customer c1 = b.addCustomer("Andrew");
        Customer c2 = b.addCustomer("Carl");
        Account a1 = b.addAccount(c1);
        Account a2 = b.addAccount(c2);

//        should fail:
        b.move((double) -100, a1, a2);

        for (Account a : b.getAccounts()) {
            System.out.println(a.getOwner().getName() + ": " + a.getBalance());
        }

    }
}
