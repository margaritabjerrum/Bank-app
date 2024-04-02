package BankApp;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BankActions {
  public ArrayList<BankAccount> accounts = new ArrayList<>();

  public BankActions() {
    this.accounts.add(new BankAccount(1001, "Margarita", 0));
    this.accounts.add(new BankAccount(1002, "Allan", 0));
  }


  public BankAccount selectOrCreateAccount() {
    Scanner sc = new Scanner(System.in);
    BankAccount selectedAccount = null;

    do {
      System.out.println("Do you have an existing account? (Y/N)");

      String accountExists = sc.nextLine().toUpperCase();

      if (accountExists.contains("Y")) {
        System.out.println("Enter your account id:");
        int id = sc.nextInt();

        for (BankAccount account : accounts) {
          if (account.getId() == id) {
            selectedAccount = account;
            System.out.println("Login successful");
          }
        }

      } else if (accountExists.contains("N")) {
        System.out.println("Enter your name to create new account:");
        String name = sc.nextLine();
        int id = accounts.size() + 1001;
        selectedAccount = new BankAccount(id, name, 0);
        accounts.add(selectedAccount);
        System.out.println("Your account was created successfully");
        System.out.println("Your account number for login in is --- " + id + " ---");
        try {
          // Write the newly created account to a text file
          FileWriter writer = new FileWriter("accounts.txt", true);
          writer.write(selectedAccount.getId() + "," + selectedAccount.getName() + "," + selectedAccount.getBalance() + "\n");
          writer.close();
        } catch (IOException e) {
          System.err.println("Error writing accounts data to CSV file: " + e.getMessage());
        }
      } else {
        System.out.println("Invalid input. Please try again");
      }

    }

    while(selectedAccount == null);

    return selectedAccount;
  }

  public void accountInteractions(BankAccount selectedAccount) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      System.out.println("Choose your action");
      System.out.println("1. Check Balance");
      System.out.println("2. Make Deposit");
      System.out.println("3. Make Withdrawal");
      System.out.println("4. Make transfer");
      System.out.println("0. Exit");

      int input = sc.nextInt();

      switch (input) {
        case 1:
          selectedAccount.printBalance();
          break;

        case 2:
          System.out.println("Enter amount to deposit:");
          double deposit = sc.nextDouble();
          selectedAccount.deposit(deposit);
          break;

        case 3:
          System.out.println("Enter amount to withdraw:");
          double withdraw = sc.nextDouble();
          selectedAccount.withdraw(withdraw);
          break;

        case 4:
          System.out.println("Enter account ID for transfer:");
          int id = sc.nextInt();
          System.out.println("Enter amount to transfer:");
          double transferAmount = sc.nextDouble();
          BankAccount accToTransferTo = null;
          for (BankAccount customer : accounts) {
            if (customer.getId() == id) {
              accToTransferTo = customer;
            } else {
              System.out.println("Invalid Id");
            }
          }
          selectedAccount.transfer(accToTransferTo, transferAmount);
          break;

        case 0:
          System.out.println("Exiting...");
          System.exit(0);

        default:
          System.out.println("Invalid choice. Please enter a number between 1 and 4.");
      }
    }
  }


}
