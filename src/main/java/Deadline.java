import java.time.LocalDateTime;

/**
 * The Deadline class is an extension of the base class Task
 */
public class Deadline extends Task {
    protected LocalDateTime by;

    /**
     * Constructor for class Deadline
     * @param description string of the Deadline's description
     * @param by LocalDateTime that represents date-time of the Deadline
     */
    public Deadline(String description, LocalDateTime by) {
        super(description);
        this.by = by;
    }

    /**
     * Outputs the date-time as a string in the format (yyyy-MM-dd HH:mm)
     * @param by LocalDateTime that represents date-time of the Deadline
     * @return String representation of date and time of the Deadline
     */
    public String byString(LocalDateTime by) {
        return by.toString().replace('T', ' ');
    }

    /**
     * Returns a string representation of a Deadline
     * @return String representation of a Deadline with appropriate icon and description
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + byString(by) + ")";
    }

    /**
     * Returns a string representation of how a Deadline is saved in text file
     * @return String representation of a deadline in text file
     */
    @Override
    public String writeLine() {
        return "D | " + (isDone ? "1" : "0") + " | " + description + " | " + byString(by);
    }
}