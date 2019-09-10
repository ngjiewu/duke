import java.util.ArrayList;

/**
 * The Ui class deals with interactions with the user.
 */
public class Ui {
    /**
     * Shows a welcome message at the start of the programme.
     */
    public void showWelcome() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What can I do for you?");
    }

    /**
     * Shows an exit message at the end of the programme.
     */
    public void showExit() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    /**
     * Shows a message indicating an error encountered when loading file.
     */
    public void showLoadingError() {
        System.out.println("Error loading file.");
    }

    /**
     * Prints out the current tasks in the TaskList.
     * @param tasks the collection whose tasks are to be printed out
     */
    public void showList(TaskList tasks) {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i + 1 + "." + tasks.get(i).toString());
        }
    }

    /**
     * Prints out the tasks that contains the searched keyword.
     * @param matchList the collection of string description of tasks to be printed
     */
    public void showMatchList(ArrayList<String> matchList) {
        System.out.println("Here are the matching tasks in your list:");
        for (int i = 0; i < matchList.size(); i++) {
            System.out.println(i + 1 + "." + matchList.get(i));
        }
    }

    /**
     * Prints a message indicating that a task has been successfully added to the TaskList and
     * prints out the current number of tasks at the end.
     * @param task the specified task that has been successfully added
     * @param tasks the collection of tasks
     */
    public void showAdded(Task task, TaskList tasks) {
        System.out.println("Got it. I've added this task:");
        System.out.println(task.toString());
        showListSize(tasks.size());
    }

    /**
     * Prints a message indicating that a specified task has been marked as done.
     * @param task the specified task that has been marked as done
     */
    public void showDone(Task task) {
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(task.toString());
    }

    /**
     * Prints a message indicating that a specified task has been deleted from the collection and
     * prints out the current number of tasks at the end.
     * @param str description of the specified task that has been deleted
     * @param tasks the collection of tasks
     */
    public void showDeleted(String str, TaskList tasks) {
        System.out.println("Noted. I've removed this task: ");
        System.out.println(str);
        showListSize(tasks.size());
    }

    /**
     * Prints out the current number of tasks in the collection.
     * @param num number of tasks in the collection
     */
    public void showListSize(int num) {
        System.out.println("Now you have " + num + " tasks in the list.");
    }

    /**
     * Prints out a message indicating that the specified field description.
     * @param str specified field description
     */
    public void showEmptyError(String str) {
        System.out.println("☹ OOPS!!! The description of an " + str + " cannot be empty.");
    }

    /**
     * Prints out a message that prompts the user to enter a valid index.
     */
    public void showIndexError() {
        System.out.println("Please enter a valid index.");
    }

    /**
     * Prints out a message indicating that the programme does not understand the user's input.
     */
    public void showUnknownCommand() {
        System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
    }
}
