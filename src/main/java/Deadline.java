import java.time.LocalDateTime;

public class Deadline extends Task {
    protected LocalDateTime by;

    public Deadline(String description, LocalDateTime by) {
        super(description);
        this.by = by;
    }

    public String byString(LocalDateTime by) {
        return by.toString().replace('T', ' ');
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + byString(by) + ")";
    }

    @Override
    public String writeLine() {
        return "D | " + (isDone ? "1" : "0") + " | " + description + " | " + byString(by);
    }
}