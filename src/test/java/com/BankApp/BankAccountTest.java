package com.BankApp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

  private BankAccount account;

  @BeforeEach
  public void setup() {
    account = new BankAccount(1, "John Doe", 1000.0);
  }

  @Test
  public void testDeposit() {
    double amount = 500.0;
    double newBalance = account.deposit(amount);
    Assertions.assertEquals(1500.0, newBalance);
  }

  @Test
  public void testWithdrawSufficientFunds() {
    double amount = 500.0;
    double newBalance = account.withdraw(amount);
    Assertions.assertEquals(500.0, newBalance);
  }

  @Test
  public void testWithdrawInsufficientFunds() {
    double amount = 1500.0; // Attempting to withdraw more than balance
    double newBalance = account.withdraw(amount);
    Assertions.assertEquals(1000.0, newBalance); // Balance should remain unchanged
  }

  @Test
  public void testTransferSufficientFunds() {
    BankAccount destinationAccount = new BankAccount(2, "Jane Doe", 500.0);
    double amount = 500.0;
    account.transfer(destinationAccount, amount);
    Assertions.assertEquals(500.0, account.getBalance());
    Assertions.assertEquals(1000.0, destinationAccount.getBalance());
  }

  @Test
  public void testTransferInsufficientFunds() {
    BankAccount destinationAccount = new BankAccount(2, "Jane Doe", 500.0);
    double amount = 1500.0; // Attempting to transfer more than balance
    account.transfer(destinationAccount, amount);
    Assertions.assertEquals(1000.0, account.getBalance()); // Balance should remain unchanged
    Assertions.assertEquals(500.0, destinationAccount.getBalance());
  }
}