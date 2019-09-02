import java.time.LocalDateTime;

public class Event extends Task {
    protected LocalDateTime at;

    public Event(String description, LocalDateTime at) {
        super(description);
        this.at = at;
    }

    public String atString(LocalDateTime at) {
        return at.toString().replace('T', ' ');
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + atString(at) + ")";
    }

    @Override
    public String writeLine() {
        return "E | " + (isDone ? "1" : "0") + " | " + description + " | " + atString(at);
    }
}