import java.util.ArrayList;

/**
 * Contains the task list, it has the operations to add/delete tasks in the list, find tasks containing a
 * keyword in the list, convert tasks to their string representations
 */
public class TaskList {
    private ArrayList<Task> tasks;

    /**
     * Constructs an empty ArrayList<Task> tasks
     */
    public TaskList() {
        tasks = new ArrayList<>();
    }

    /**
     * Constructs tasks containing the elements of the specified collection
     * @param tasks the collection whose tasks are to be placed into ArrayList<Task> tasks
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Returns the task at the specified position in tasks
     * @param index index of the task to return
     * @return the task at the specified position in tasks
     */
    public Task get(int index) {
        return tasks.get(index);
    }

    /**
     * Appends the specified task to the end of tasks
     * @param task to be appended to tasks
     */
    public void add(Task task) {
        tasks.add(task);
    }

    /**
     * Removes the task at the specified position in tasks. Shifts any subsequent task to the left
     * @param index index of the task to be removed
     */
    public void delete(int index) {
        tasks.remove(index);
    }

    /**
     * Returns the number of elements in tasks
     * @return the number of elements in tasks
     */
    public int size() {
        return tasks.size();
    }

    /**
     * Returns a string representation of the task
     * @param index index of the task to be converted to string representation
     * @return string representation of the specified task
     */
    public String toString(int index) {
       return tasks.get(index).toString();
    }

    /**
     * Returns a string ArrayList of description of tasks that contains the keyword
     * @param keyword String whose presence in this tasks collection is to be tested
     * @return ArrayList<String> containing the string representation of the tasks containing the keyword
     */
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