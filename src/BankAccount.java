public class BankAccount {
  private double balance;

  public BankAccount() {

  }

  public BankAccount(double balance) {
    this.balance = balance;
  }

  public double deposit(double amount) {
    System.out.println(amount + "€ was added to your account :)" );
    return balance += amount;
  }
  public double withdraw(double amount) {
    if (balance < amount) {
      System.out.println("Error: insufficient funds");
    } else {
      System.out.println(amount + "€ was withdrawn from your account :(" );
      balance -= amount;
    }
    return balance;
  }

  public void printBalance() {
    System.out.println("Account Balance is: " + balance + "€");
  }

  public void transfer(BankAccount destinationAccount, double amount) {
    if (balance < amount) {
      System.out.println("Error: insufficient funds for transfer");
    } else {
      withdraw(amount); // Withdraw from this account
      destinationAccount.deposit(amount); // Deposit into the destination account
      System.out.println(amount + "€ was transferred from your account to destination account");
    }
  }

}
