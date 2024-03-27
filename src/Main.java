public class Main {
  public static void main(String[] args) {

    BankAccount account1 = new BankAccount(1000);
    BankAccount account2 = new BankAccount(1500);

    //Print original balance
    System.out.println("Original account balance");
    account1.printBalance();
    account2.printBalance();
    System.out.println("-------------------------");

    //Add funds to account
    System.out.println("Account balance after funds were added");
    account1.deposit(100);
    account2.deposit(200);
    account1.printBalance();
    account2.printBalance();
    System.out.println("-------------------------");

    //Withdraw funds from account
    System.out.println("Account balance after funds were withdrawn");
    account1.withdraw(400);
    account2.withdraw(2000);
    account1.printBalance();
    account2.printBalance();
    System.out.println("-------------------------");

    //Transfer funds between accounts
    account1.transfer(account2, 200);
    System.out.println("-------------------------");

    System.out.println("Latest account balance");
    account1.printBalance();
    account2.printBalance();
  }
}