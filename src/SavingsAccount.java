/**
 * Represents a savings account with an initial balance of zero.
 */
public class SavingsAccount extends BankAccount {
  private final String ownerName;

  /**
   * Creates a savings account for the specified owner.
   *
   * @param ownerName the account owner's name
   */
  public SavingsAccount(String ownerName) {
    super(ownerName, 0.0);
    this.ownerName = ownerName;
  }

  @Override
  public String getOwnerName() {
    return ownerName;
  }
}