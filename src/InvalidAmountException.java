/**
 * Exception thrown when a deposit or withdrawal amount is invalid.
 */
public class InvalidAmountException extends Exception {
  private static final long serialVersionUID = 1L;

  private final String message;

  /**
   * Creates an exception with the specified message.
   *
   * @param message the reason the amount is invalid
   */
  public InvalidAmountException(String message) {
    this.message = message;
  }

  @Override
  public String getMessage() {
    return message;
  }
}
