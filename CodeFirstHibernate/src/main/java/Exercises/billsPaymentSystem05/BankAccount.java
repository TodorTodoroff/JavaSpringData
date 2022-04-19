package Exercises.billsPaymentSystem05;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "_05_bank_accounts")
public class BankAccount extends BillingDetails {


    @Column(nullable = false)
    private String name;

    @Column(name = "swift_code", nullable = false)
    private String swiftCode;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public BankAccount() {
    }

    public BankAccount(int number, String owner, String name, String swiftCode) {
        super(number, owner);
        this.name = name;
        this.swiftCode = swiftCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }
}
