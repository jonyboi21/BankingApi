package com.atm.atmproject.models;

import com.atm.atmproject.enums.AccountType;

import javax.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ACCOUNT_ID")
    private Long id;

    @Column(name = "type")
    private AccountType type;

    @Column(name = "NICKNAME")
    private String nickname;

    @Column(name = "REWARDS")
    private Integer rewards;

    @Column(name = "BALANCE")
    private Double balance;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_Account")
    private Customer customer;

    public Account() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getRewards() {
        return rewards;
    }

    public void setRewards(Integer rewards) {
        this.rewards = rewards;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", rewards=" + rewards +
                ", balance=" + balance +
                ", customer=" + customer +
                '}';
    }
}
