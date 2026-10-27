import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a transaction made on a bank account.
 */
public class Transaction {
  private static final DateTimeFormatter TIMESTAMP_FORMAT =
      DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

  private LocalDateTime timeStamp;
  private String type;
  private double amount;

  /**
   * Creates a transaction using the current date and time.
   *
   * @param type the type of transaction
   * @param amount the transaction amount
   */
  public Transaction(String type, double amount) {
    this(LocalDateTime.now(), type, amount);
  }

  /**
   * Creates a transaction with the specified timestamp, type, and amount.
   *
   * @param timestamp the date and time of the transaction
   * @param type the type of transaction
   * @param amount the transaction amount
   */
  public Transaction(LocalDateTime timestamp, String type, double amount) {
    this.timeStamp = timestamp;
    this.type = type;
    this.amount = amount;
  }

  /**
   * Returns the transaction's timestamp.
   *
   * @return the date and time of the transaction
   */
  public LocalDateTime getTimestamp() {
    return timeStamp;
  }

  /**
   * Returns the transaction type.
   *
   * @return the type of transaction
   */
  public String getType() {
    return type;
  }

  /**
   * Returns the transaction amount.
   *
   * @return the transaction amount
   */
  public double getAmount() {
    return amount;
  }

  /**
   * Returns a string representation of this transaction.
   *
   * @return the transaction type, amount, and timestamp
   */
  @Override
  public String toString() {
    return "Transaction [type=" + type
        + ", amount=" + amount
        + ", time_stamp=" + timeStamp.format(TIMESTAMP_FORMAT)
        + "]";
  }
}
