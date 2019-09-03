import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) throws DukeException {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What can I do for you?");

        ArrayList<Task> tasks = new ArrayList<>();
        Storage.loadFile(tasks);

        Scanner input = new Scanner(System.in);
        String command = input.nextLine();
        while (!command.equals("bye")) {
            String[] tokens = command.split(" ");
            int numOfTasks = tasks.size();

            switch (tokens[0]) {
                case "list":
                    System.out.println("Here are the tasks in your list:");
                    for (int i = 0; i < numOfTasks; i++) {
                        System.out.println(i+1 + "." + tasks.get(i).toString());
                    }
                    break;

                case "todo":
                    if (!command.substring(5).isBlank()) {
                        tasks.add(new Todo(command.substring(5)));
                        System.out.println("Got it. I've added this task:");
                        System.out.println(tasks.get(numOfTasks).toString());
                        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                    } else {
                        System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
                    }
                    break;

                case "deadline":
                    try {
                        String[] token = command.substring(9).split(" /by ");
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                        LocalDateTime dateTime = LocalDateTime.parse(token[1], formatter);
                        tasks.add(new Deadline(token[0], dateTime));
                        System.out.println("Got it. I've added this task:");
                        System.out.println(tasks.get(numOfTasks).toString());
                        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                    } catch (Exception e) {
                        System.out.println("☹ OOPS!!! The description of a deadline cannot be empty.");
                    }
                    break;

                case "event":
                    try {
                        String[] token = command.substring(6).split(" /at ");
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                        LocalDateTime dateTime = LocalDateTime.parse(token[1], formatter);
                        tasks.add(new Event(token[0], dateTime));
                        System.out.println("Got it. I've added this task:");
                        System.out.println(tasks.get(numOfTasks).toString());
                        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                    } catch (Exception e) {
                        System.out.println("☹ OOPS!!! The description of an event cannot be empty.");
                    }
                    break;

                case "done":
                    try {
                        int getIndex = Integer.parseInt(tokens[1]) - 1;
                        tasks.get(getIndex).markAsDone();
                        System.out.println("Nice! I've marked this task as done:");
                        System.out.println(tasks.get(getIndex).toString());
                        break;
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Please enter a valid index.");
                    }
                    break;

                case "delete":
                    try {
                        int getIndex = Integer.parseInt(tokens[1]) - 1;
                        String taskDescription = tasks.get(getIndex).toString();
                        tasks.remove(getIndex);
                        System.out.println("Noted. I've removed this task: ");
                        System.out.println(taskDescription);
                        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Please enter a valid index.");
                    }
                    break;

                case "find":
                    try {
                        String keyword = command.substring(5);
                        if (keyword.isBlank()) {
                            System.out.println("☹ OOPS!!! You cannot find something empty!");
                        } else {
                            ArrayList<String> matchList = new ArrayList<>();
                            for (Task task : tasks) {
                                if (task.toString().contains(keyword)) {
                                    matchList.add(task.toString());
                                }
                            }
                            System.out.println("Here are the matching tasks in your list:");
                            for (int i = 0; i < matchList.size(); i++) {
                                System.out.println(i + 1 + matchList.get(i));
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("☹ OOPS!!! You cannot find something empty!");
                    }
                    break;

                default:
                    System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                    break;
            }
            command = input.nextLine();
        }
        Storage.saveFile(tasks);
        System.out.println("Bye. Hope to see you again soon!");
    }
}