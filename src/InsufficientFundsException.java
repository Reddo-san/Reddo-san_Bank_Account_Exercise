/**
 * Exception thrown when a withdrawal exceeds the available balance.
 */
public class InsufficientFundsException extends Exception {
  private static final long serialVersionUID = 1L;

  private final String message;

  /**
   * Creates an exception with the specified message.
   *
   * @param message the reason the withdrawal could not be completed
   */
  public InsufficientFundsException(String message) {
    this.message = message;
  }

  @Override
  public String getMessage() {
    return message;
  }
}