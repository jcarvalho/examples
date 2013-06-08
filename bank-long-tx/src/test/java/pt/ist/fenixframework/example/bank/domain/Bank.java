package pt.ist.fenixframework.example.bank.domain;

public class Bank extends Bank_Base {

    public Bank() {
        super();
        setCustomerId(0l);
    }

    public Customer createCustomer(String name) {
        long currentId = this.getCustomerId() + 1;
        setCustomerId(currentId);
        Customer customer = new Customer(currentId, name);
        this.addCustomer(customer);
        return customer;
    }

}
