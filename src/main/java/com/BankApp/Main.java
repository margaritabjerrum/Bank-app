package com.BankApp;

public class Main {
  public static void main(String[] args) {
    BankActions bankActions = new BankActions();
    BankAccount selectedAccount = bankActions.selectOrCreateAccount();
    bankActions.accountInteractions(selectedAccount);

  }

}