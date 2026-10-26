/**
 * Exception thrown when an invalid amount is deposited or withdrawn.
 */
public class AccountFrozenException extends Exception {
  private static final long serialVersionUID = 1L;

  private final String message;

  /**
   * Creates an exception with the specified message.
   *
   * @param message the reason the operation could not be completed
   */
  public AccountFrozenException(String message) {
    this.message = message;
  }

  @Override
  public String getMessage() {
    return message;
  }
}