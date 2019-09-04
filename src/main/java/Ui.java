import java.util.ArrayList;

public class Ui {
    public void showWelcome() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What can I do for you?");
    }

    public void showExit() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    public void showLoadingError() {
        System.out.println("Error loading file.");
    }

    public void showList(TaskList tasks) {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i+1 + "." + tasks.get(i).toString());
        }
    }

    public void showMatchList(ArrayList<String> matchList) {
        System.out.println("Here are the matching tasks in your list:");
        for (int i = 0; i < matchList.size(); i++) {
            System.out.println(i+1 + "." + matchList.get(i));
        }
    }

    public void showAdded(Task task, TaskList tasks) {
        System.out.println("Got it. I've added this task:");
        System.out.println(task.toString());
        showListSize(tasks.size());
    }

    public void showDone(Task task) {
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(task.toString());
    }

    public void showDeleted(String str, TaskList tasks) {
        System.out.println("Noted. I've removed this task: ");
        System.out.println(str);
        showListSize(tasks.size());
    }

    public void showListSize(int num) {
        System.out.println("Now you have " + num + " tasks in the list.");
    }

    public void showEmptyError(String str) {
        System.out.println("☹ OOPS!!! The description of an " + str + " cannot be empty.");
    }

    public void showIndexError() {
        System.out.println("Please enter a valid index.");
    }

    public void showUnknownCommand() {
        System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
    }
}
