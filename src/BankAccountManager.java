import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Manages bank accounts stored by their IDs.
 */
public class BankAccountManager implements Bank {
  private final Map<Integer, BankAccount> accounts;
  private int id;

  /**
   * Creates an account manager with no accounts and an initial ID of zero.
   */
  public BankAccountManager() {
    accounts = new HashMap<>();
    id = 0;
  }

  /**
   * Adds an account and assigns it the next available ID.
   *
   * @param account the account to add
   * @throws NullPointerException if {@code account} is {@code null}
   * @throws IllegalStateException if the manager already contains 100 accounts
   */
  @Override
  public void addAccount(BankAccount account) {
    Objects.requireNonNull(account, "account");
    if (accounts.size() >= 100) {
      throw new IllegalStateException("Cannot add more than 100 bank accounts.");
    }

    accounts.put(id, account);
    System.out.println("Account added successfully with ID: " + id);
    id++;
  }

  /**
   * Returns the account associated with an ID.
   *
   * @param id the ID to look up
   * @return the account for that ID, or {@code null} if no account exists
   */
  @Override
  public BankAccount getAccount(int id) {
    return accounts.get(id);
  }

  /**
   * Displays each account's ID, owner's name, and balance.
   */
  public void listAccounts() {
    for (Map.Entry<Integer, BankAccount> entry : accounts.entrySet()) {
      BankAccount account = entry.getValue();
      System.out.printf("Account ID: %d, Account Name: %s, Balance: %s%n",
          entry.getKey(), account.getOwnerName(), Double.toString(account.getBalance()));
    }
  }

  /**
   * Returns transactions whose amounts are at least the specified amount.
   *
   * @param amount the minimum transaction amount to include
   * @param txList the transactions to filter
   * @return a new list containing the matching transactions
   */
  public List<Transaction> filterTransactionsAtOrAbove(double amount, List<Transaction> txList) {
    Objects.requireNonNull(txList, "txList");
    return txList.stream()
        .filter(transaction -> transaction.getAmount() >= amount)
        .collect(Collectors.toList());
  }

  /**
   * Returns transactions sorted by amount in ascending order.
   *
   * @param txList the transactions to sort
   * @return a new list containing the transactions in ascending amount order
   */
  public List<Transaction> sortTransactionsByAmount(List<Transaction> txList) {
    Objects.requireNonNull(txList, "txList");
    return txList.stream()
        .sorted((first, second) -> Double.compare(first.getAmount(), second.getAmount()))
        .collect(Collectors.toList());
  }
}
