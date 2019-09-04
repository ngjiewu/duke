import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<Task>();
    }

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public Task get(int index) {
        return this.tasks.get(index);
    }

    public void add(Task task) {
        this.tasks.add(task);
    }

    public int size() {
        return this.tasks.size();
    }

    public String toString(int index) {
       return tasks.get(index).toString();
    }

    public void delete(int index) {
        this.tasks.remove(index);
    }

    public ArrayList<String> findKeyword(String keyword) {
        ArrayList<String> matchList = new ArrayList<>();
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).toString().contains(keyword)) {
                matchList.add(tasks.get(i).toString());
            }
        }
        return matchList;
    }
}