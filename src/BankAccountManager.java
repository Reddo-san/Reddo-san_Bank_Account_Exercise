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

  public BankAccountManager() {
    accounts = new HashMap<>();
    id = 0;
  }

  @Override
  public void addAccount(BankAccount account) {
    Objects.requireNonNull(account, "account");
    if (accounts.size() >= 100) {
      throw new IllegalStateException("Cannot add more than 100 bank accounts.");
    }

    accounts.put(id, account);
    id++;
  }

  @Override
  public BankAccount getAccount(int id) {
    return accounts.get(id);
  }

  @Override
  public void listAccounts() {
    for (Map.Entry<Integer, BankAccount> entry : accounts.entrySet()) {
      BankAccount account = entry.getValue();
      System.out.printf("ID: %d, Owner: %s, Balance: %.2f%n",
          entry.getKey(), account.getOwnerName(), account.getBalance());
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
