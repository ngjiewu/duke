public class Task {
    protected String description;
    protected boolean isDone;
    private static int taskCounter = 0;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
        taskCounter++;
    }

    public String getStatusIcon() {
        return (isDone ? "✓" : "✗");
    }
    public void markAsDone() {
        this.isDone = true;
    }
    public static int getTaskCounter() {
        return taskCounter;
    }

    public String toString() {
        return ("[" + this.getStatusIcon() + "] " + this.description);
    }
}
