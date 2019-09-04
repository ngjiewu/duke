import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Parser {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static void execute(String command, Ui ui, TaskList tasks) {
        String[] tokens = command.split(" ");
        switch (tokens[0]) {
            case "list":
                ui.showList(tasks.getTask());
                break;

            case "todo":
                try {
                    if (!command.substring(5).isBlank()) {
                        Task todo = new Todo(command.substring(5));
                        tasks.add(todo);
                        ui.showAdded(todo);
                        ui.showListSize(tasks.size());
                    } else {
                        System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
                    }
                } catch (Exception e) {
                    System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
                }
                break;

            case "deadline":
                try {
                    String[] token = command.substring(9).split(" /by ");
                    LocalDateTime dateTime = LocalDateTime.parse(token[1], formatter);
                    Deadline deadline = new Deadline(token[0], dateTime);
                    tasks.add(deadline);
                    ui.showAdded(deadline);
                    ui.showListSize(tasks.size());
                } catch (Exception e) {
                    System.out.println("☹ OOPS!!! The description of a deadline cannot be empty.");
                }
                break;

            case "event":
                try {
                    String[] token = command.substring(6).split(" /at ");
                    LocalDateTime dateTime = LocalDateTime.parse(token[1], formatter);
                    Event event = new Event(token[0], dateTime);
                    tasks.add(event);
                    ui.showAdded(event);
                    ui.showListSize(tasks.size());
                } catch (Exception e) {
                    System.out.println("☹ OOPS!!! The description of an event cannot be empty.");
                }
                break;

            case "done":
                try {
                    String num = command.substring(5);
                    int index = Integer.parseInt(num) - 1;
                    tasks.markAsDone(index);
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println(tasks.toString(index));
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Please enter a valid index.");
                }
                break;

            case "delete":
                try {
                    String num = command.substring(7);
                    int index = Integer.parseInt(num) - 1;
                    String taskDescription = tasks.toString(index);
                    tasks.delete(index);
                    System.out.println("Noted. I've removed this task: ");
                    System.out.println(taskDescription);
                    ui.showListSize(tasks.size());
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
                        for (Task task : tasks.getTask()) {
                            if (task.toString().contains(keyword)) {
                                matchList.add(task.toString());
                            }
                        }

                        System.out.println("Here are the matching tasks in your list:");
                        for (int i = 0; i < matchList.size(); i++) {
                            System.out.println(i+1 + "." + matchList.get(i));
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
    }
}
