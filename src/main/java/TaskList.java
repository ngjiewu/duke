import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<Task>();
    }

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void add(Task task) {
        this.tasks.add(task);
    }

    public ArrayList<Task> getTask() {
        return this.tasks;
    }

    public int size() {
        return this.tasks.size();
    }

    public void markAsDone(int index) {
        Task task = tasks.get(index);
        task.markAsDone();
    }

    public String toString(int index) {
       return tasks.get(index).toString();
    }

    public void delete(int index) {
        this.tasks.remove(index);
    }
}