import java.time.LocalDateTime;

/**
 * The Event class is an extension of the base class Task
 */
public class Event extends Task {
    protected LocalDateTime at;

    /**
     * Constructor for class Event
     * @param description string of the Event's description
     * @param at LocalDateTime that represents date-time of the Event
     */
    public Event(String description, LocalDateTime at) {
        super(description);
        this.at = at;
    }

    /**
     * Outputs the date-time as a string in the format (yyyy-MM-dd HH:mm)
     * @param at LocalDateTime that represents date-time of the Event
     * @return String representation of date and time of the Event
     */
    public String atString(LocalDateTime at) {
        return at.toString().replace('T', ' ');
    }

    /**
     * Returns a string representation of an Event
     * @return String representation of an Event with appropriate icon and description
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + atString(at) + ")";
    }

    /**
     * Returns a string representation of how an Event is saved in text file
     * @return String representation of an event in text file
     */
    @Override
    public String writeLine() {
        return "E | " + (isDone ? "1" : "0") + " | " + description + " | " + atString(at);
    }
}