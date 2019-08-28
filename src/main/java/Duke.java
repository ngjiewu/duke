import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What can I do for you?");

        Task[] tasks = new Task[100];
        while (true) {
            Scanner in = new Scanner(System.in);
            String command = in.nextLine();
            String[] tokens = command.split(" ");
            int numOfTasks = Task.getTaskCounter();

            if (command.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < numOfTasks; i++) {
                    System.out.println(i+1 + "." + tasks[i].toString());
                }
            } else if (tokens[0].equals("done")) {
                int getIndex = Integer.parseInt(tokens[1]) - 1;
                tasks[getIndex].markAsDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println(tasks[getIndex].toString());
            } else if (tokens[0].equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            } else if (tokens[0].equals("deadline")) {
                try {
                    String[] token = command.substring(9).split(" /by ");
                    tasks[numOfTasks] = new Deadline(token[0], token[1]);
                    System.out.println("Got it. I've added this task:");
                    System.out.println(tasks[numOfTasks].toString());
                    System.out.println("Now you have " + Task.getTaskCounter() + " tasks in the list.");
                } catch (Exception e) {
                    System.out.println(" ☹ OOPS!!! The description of a deadline cannot be empty.");
                }
            } else if (tokens[0].equals("event")) {
                try {
                    String[] token = command.substring(6).split(" /at ");
                    tasks[numOfTasks] = new Event(token[0], token[1]);
                    System.out.println("Got it. I've added this task:");
                    System.out.println(tasks[numOfTasks].toString());
                    System.out.println("Now you have " + Task.getTaskCounter() + " tasks in the list.");
                } catch (Exception e) {
                    System.out.println(" ☹ OOPS!!! The description of an event cannot be empty.");
                }
            } else if (tokens[0].equals("todo")){
                if (command.length() > 5) {
                    tasks[numOfTasks] = new Todo(command.substring(5));
                    System.out.println("Got it. I've added this task:");
                    System.out.println(tasks[numOfTasks].toString());
                    System.out.println("Now you have " + Task.getTaskCounter() + " tasks in the list.");
                } else {
                    System.out.println(" ☹ OOPS!!! The description of a todo cannot be empty.");
                }
            } else {
                System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
            }
        }
    }
}