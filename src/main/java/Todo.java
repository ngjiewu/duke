/**
 * The Todo class is an extension of the base class Task.
 */
public class Todo extends Task {
    /**
     * Constructor for class Todo.
     * @param description string of the Todo's description
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Returns a string representation of a Todo.
     * @return String representation of a Todo with appropriate icon and description
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    /**
     * Returns a string representation of how a Todo is saved in text file.
     * @return String representation of a Todo in text file
     */
    @Override
    public String writeLine() {
        return "T | " + (isDone ? "1" : "0") + " | " + description;
    }
}