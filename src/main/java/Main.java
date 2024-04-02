import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    BankActions bankActions = new BankActions();
    BankAccount selectedAccount = bankActions.selectOrCreateAccount();
    bankActions.accountInteractions(selectedAccount);

  }

}