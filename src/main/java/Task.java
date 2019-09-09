/**
 * The Task class is the base class for different types of tasks
 */
public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Constructor for class Task
     * @param description string of the Task's description
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Obtains a string icon to indicate if the task is done
     * @return "+" if Task is done, otherwise "-"
     */
    public String getStatusIcon() {
        return (isDone ? "+" : "-");
    }

    /**
     * Sets the task as done
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * Returns a string representation of a Task
     * @return String representation of the Task with appropriate icon and description
     */
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }

    /**
     * Method to be called to return a string representation of how a Task is saved in text file
     * @return String representation of how the task is saved in text file
     */
    public String writeLine() {
        return "";
    }
}
