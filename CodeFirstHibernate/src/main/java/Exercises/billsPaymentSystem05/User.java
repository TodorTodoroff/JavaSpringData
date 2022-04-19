package Exercises.billsPaymentSystem05;


import javax.persistence.*;
import java.util.Set;

@Entity(name = "_05_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fist_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(unique = true)
    private String email;

    private String password;

    @OneToMany
    @JoinColumn(name = "credit_card_id",referencedColumnName = "id")
    private Set<BankAccount> bankAccount;

    @OneToMany
    @JoinColumn(name = "credit_card_id",referencedColumnName = "id")
    private Set<CreditCard> creditCard;

public User(){
}

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<BankAccount> getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(Set<BankAccount> bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Set<CreditCard> getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(Set<CreditCard> creditCard) {
        this.creditCard = creditCard;
    }
}
