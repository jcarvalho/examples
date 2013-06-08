package pt.ist.fenixframework.example.bank.domain;

import org.joda.time.DateTime;

public class Customer extends Customer_Base {

    public Customer(Long id, String name) {
        super();
        setId(id);
        setJoined(new DateTime());
        setName(name);
    }

    public Money getTotalBalance() {
        Money result = Money.ZERO;

        for (Account acc : getAccountSet()) {
            result = result.add(acc.getBalance());
        }

        return result;
    }

}
