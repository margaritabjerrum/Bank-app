import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    BankAccount account1 = new BankAccount();
    BankAccount account2 = new BankAccount();

    Scanner sc = new Scanner(System.in);

    boolean isRightAccountNumber = true;
    BankAccount selectedAccount = account1;
    do {
      System.out.println("Enter your account name:");
      String accountSelectionTest = sc.nextLine();
        switch (accountSelectionTest) {
          case "account1":
            selectedAccount = account1;
            isRightAccountNumber = false;
            break;
          case "account2":
            selectedAccount = account2;
            isRightAccountNumber = false;
            break;
          default:
            System.out.println("Invalid input. Please enter correct account number");
        }

    }
    while (isRightAccountNumber);

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
          System.out.println("Enter amount to transfer:");
          double transferAmount = sc.nextDouble();
            selectedAccount.transfer(account2, transferAmount);
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