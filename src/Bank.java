/**
 * Defines operations for managing bank accounts.
 */
interface Bank {
  /**
   * Adds an account to the bank.
   *
   * @param account the account to add
   */
  void addAccount(BankAccount account);

  /**
   * Finds an account by its ID.
   *
   * @param id the ID of the account to retrieve
   * @return the account with the specified ID, or {@code null} if no account exists
   */
  BankAccount getAccount(int id);
}