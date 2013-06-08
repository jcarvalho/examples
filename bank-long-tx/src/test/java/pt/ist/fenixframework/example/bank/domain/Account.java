package pt.ist.fenixframework.example.bank.domain;

public class Account extends Account_Base {

    public Account(Customer owner) {
        super();
        setOwner(owner);
        setBalance(Money.ZERO);
    }

    public void withdraw(Money amount) {
        if (getBalance().lessThan(amount)) {
            throw new InsufficientFundsException("Trying to withdraw " + amount + ", but only " + getBalance() + " available");
        }

        setBalance(getBalance().subtract(amount));
    }

    public void deposit(Money amount) {
        setBalance(getBalance().add(amount));
    }

}
