package com.BankApp;

public class BankAccount {

  private int id;
  private String name;
  private double balance;

  public BankAccount() {

  }

  public BankAccount(int id, String name, double balance) {
    this.id = id;
    this.name = name;
    this.balance = balance;
  }


  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public double deposit(double amount) {
    System.out.println(amount + "eur was added to your account" );
    return balance += amount;
  }
  public double withdraw(double amount) {
    if (balance < amount) {
      System.out.println("Error: insufficient funds");
    } else {
      System.out.println(amount + "eur was withdrawn from your account" );
      balance -= amount;
    }
    return balance;
  }

  public void printBalance() {
    System.out.println("Account Balance is: " + balance + "eur");
  }

  public void transfer(BankAccount destinationAccount, double amount) {
    if (balance < amount) {
      System.out.println("Error: insufficient funds for transfer");
    } else {
      withdraw(amount); // Withdraw from this account
      destinationAccount.deposit(amount); // Deposit into the destination account
      System.out.println(amount + "eur was transferred from your account to destination account");
    }
  }

}
