/**
 * Main class that demonstrates a savings account and bank account management.
 */
public class Main {
  /**
   * Demonstrates savings account transactions and account management.
   *
   * @param args command-line arguments (unused)
   */
  public static void main(String[] args) {
    // Create a SavingsAccount instance
    BankAccount acc1 = new SavingsAccount("Test0");

    // Display account details
    System.out.println("Account Owner: " + acc1.getOwnerName());
    System.out.println("Initial Balance: " + acc1.getBalance());

    // Perform some transactions
    deposit(acc1, 1000.0);
    System.out.println("Current Balance: " + acc1.getBalance());

    // Deposit 0.0 to test the deposit validation
    deposit(acc1, 0.0); // This should not be allowed
    System.out.println("Current Balance: " + acc1.getBalance());

    // Deposit a negative amount to test the deposit validation
    deposit(acc1, -500.0); // This should not be allowed
    System.out.println("Current Balance: " + acc1.getBalance());

    // Withdraw an amount
    withdraw(acc1, 500.0);
    System.out.println("Current Balance: " + acc1.getBalance());

    //Withdraw an amount greater than the balance to test the withdrawal validation
    withdraw(acc1, 600.0); // This should not be allowed
    System.out.println("Current Balance: " + acc1.getBalance());

    //withdraw a negative amount to test the withdrawal validation
    withdraw(acc1, -100.0); // This should not be allowed
    System.out.println("Current Balance: " + acc1.getBalance());

    // Freeze the account and attempt a withdrawal
    acc1.freezeAccount();
    withdraw(acc1, 200.0); // This should not be allowed

    //Freeze the account and attempt a deposit
    deposit(acc1, 100.0); // This should not be allowed

    // Unfreeze the account and attempt a withdrawal again
    acc1.unfreezeAccount();
    withdraw(acc1, 300.0);
    System.out.println("Balance after withdrawal: " + acc1.getBalance());

    // Deposit an amount after unfreezing the account
    deposit(acc1, 200.13);

    // Display transaction history
    System.out.println("Transaction History:");
    for (Transaction transaction : acc1.getTransactionHistory()) {
      System.out.println("Type: " + transaction.getType() 
                + ", Amount: " + transaction.getAmount()
                + ", Timestamp: " + transaction.getTimestamp());
    }

    //Create a Bank Account Manager
    BankAccountManager manager = new BankAccountManager();

    //Add acc1 under the Bank Account Manager
    manager.addAccount(acc1);

    //Create a new account under Bank Account Manager
    SavingsAccount acc2 = new SavingsAccount("Test1");
    manager.addAccount(acc2);

    //List all the created account under Bank Account Manager
    manager.listAccounts();

    //Deposit with a negative amount to test the deposit validation
    deposit(acc1, -500.0); // This should not be allowed

    //Deposit when the account is frozen to test the deposit validation
    acc1.freezeAccount();
    deposit(acc1, 11500.0); // This should not be allowed

    acc1.unfreezeAccount();

    //withdraw with a negative amount to test the withdrawal validation
    withdraw(acc1, -100.0); // This should not be allowed


  }

  private static void deposit(BankAccount account, double amount) {
    try {
      account.deposit(amount);
    } catch (AccountFrozenException | InvalidAmountException exception) {
      System.out.println(exception.getMessage());
    }
  }

  private static void withdraw(BankAccount account, double amount) {
    try {
      account.withdraw(amount);
    } catch (AccountFrozenException | InvalidAmountException 
      | InsufficientFundsException exception) {
      System.out.println(exception.getMessage());
    }
  }
}