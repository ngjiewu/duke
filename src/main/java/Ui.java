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

    public void showList(ArrayList<Task> tasks) {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i+1 + "." + tasks.get(i).toString());
        }
    }

    public void showAdded(Task task) {
        System.out.println("Got it. I've added this task:");
        System.out.println(task.toString());
    }

    public void showListSize(int num) {
        System.out.println("Now you have " + num + " tasks in the list.");
    }
}
