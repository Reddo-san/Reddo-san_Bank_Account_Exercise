import java.util.ArrayList;
import java.util.List;

/**
 * Represents a bank account with deposit, withdrawal, and freeze/unfreeze capabilities.
 *
 * <p>This class manages a bank account's balance, account number, and frozen status.
 * Deposits and withdrawals are disallowed while the account is frozen.</p>
 *
 * @author Arman Redrino
 * @version 1.0
 * @since 2026-10-22
 */
public class BankAccount {
  private String accountNumber;
  private double balance;
  private boolean isFrozen;
  private List<Transaction> transactionHistory;

  /**
   * Creates a bank account with the specified account number and initial balance.
   *
   * @param accountNumber the account's number
   * @param initialBalance the account's starting balance
   */
  public BankAccount(String accountNumber, double initialBalance) {
    this.accountNumber = accountNumber;
    this.balance = initialBalance;
    this.isFrozen = false;
    this.transactionHistory = new ArrayList<>();
    checkFrozenStatus();
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public String getOwnerName() {
    return accountNumber;
  }

  /**
   * Returns the account's current balance.
   *
   * @return the current balance
   */
  public double getBalance() {
    return balance;
  }

  /**
   * Deposits a positive amount into the account.
   *
   * @param amount the amount to deposit
   * @throws AccountFrozenException if the account is frozen
   * @throws InvalidAmountException if the amount is zero or negative
   */
  public void deposit(double amount) throws AccountFrozenException, InvalidAmountException {
    if (isFrozen) {
      throw new AccountFrozenException("Account is FROZEN. Unable to transact.");
    }
    System.out.println("Amount Deposited: " + amount);
    if (!(amount > 0)) {
      throw new InvalidAmountException("Invalid amount. Must be greater than 0");
    }

    balance += amount;
    transactionHistory.add(new Transaction("Deposit", amount));
  }

  /**
   * Withdraws a positive amount from the account.
   *
   * @param amount the amount to withdraw
   * @throws AccountFrozenException if the account is frozen
   * @throws InvalidAmountException if the amount is zero or negative
   * @throws InsufficientFundsException if the balance is less than the amount
   */
  public void withdraw(double amount)
      throws AccountFrozenException, InvalidAmountException, InsufficientFundsException {
    if (isFrozen) {
      throw new AccountFrozenException("Account is FROZEN. Unable to transact.");
    }
    System.out.println("Amount Withdrawn: " + amount);
    if (!(amount > 0)) {
      throw new InvalidAmountException("Invalid amount. Must be greater than 0");
    }
    if (amount > balance) {
      throw new InsufficientFundsException("Insufficient balance.");
    }

    balance -= amount;
    transactionHistory.add(new Transaction("Withdraw", amount));
  }

  public List<Transaction> getTransactionHistory() {
    return transactionHistory;
  }

  public void freezeAccount() {
    isFrozen = true;
    System.out.println("Account " + accountNumber + " has been frozen.");
  }

  public void unfreezeAccount() {
    isFrozen = false;
    System.out.println("Account " + accountNumber + " has been unfrozen.");
  }

  public boolean isFrozen() {
    return isFrozen;
  }

  private void checkFrozenStatus() {
    if (isFrozen) {
      System.out.println("Account " + accountNumber + " is currently frozen.");
    } else {
      System.out.println("Account " + accountNumber + " is active.");
    }
  }
}
