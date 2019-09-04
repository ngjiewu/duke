import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Parser {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static void execute(String command, Ui ui, TaskList tasks) {
        String[] tokens = command.split(" ");
        switch (tokens[0]) {
            case "list":
                ui.showList(tasks);
                break;

            case "todo":
                try {
                    if (!command.substring(5).isBlank()) {
                        Task todo = new Todo(command.substring(5));
                        tasks.add(todo);
                        ui.showAdded(todo, tasks);
                    } else {
                        ui.showEmptyError("todo");
                    }
                } catch (Exception e) {
                    ui.showEmptyError("todo");
                }
                break;

            case "deadline":
                try {
                    String[] token = command.substring(9).split(" /by ");
                    LocalDateTime dateTime = LocalDateTime.parse(token[1], formatter);
                    Deadline deadline = new Deadline(token[0], dateTime);
                    tasks.add(deadline);
                    ui.showAdded(deadline, tasks);
                } catch (Exception e) {
                    ui.showEmptyError("deadline");
                }
                break;

            case "event":
                try {
                    String[] token = command.substring(6).split(" /at ");
                    LocalDateTime dateTime = LocalDateTime.parse(token[1], formatter);
                    Event event = new Event(token[0], dateTime);
                    tasks.add(event);
                    ui.showAdded(event, tasks);
                } catch (Exception e) {
                    ui.showEmptyError("event");
                }
                break;

            case "done":
                try {
                    int index = Integer.parseInt(command.substring(5)) - 1;
                    Task task = tasks.get(index);
                    task.markAsDone();
                    ui.showDone(task);
                } catch (IndexOutOfBoundsException e) {
                    ui.showIndexError();
                }
                break;

            case "delete":
                try {
                    int index = Integer.parseInt(command.substring(7)) - 1;
                    String str = tasks.toString(index);
                    tasks.delete(index);
                    ui.showDeleted(str, tasks);
                } catch (IndexOutOfBoundsException e) {
                    ui.showIndexError();
                }
                break;

            case "find":
                try {
                    String keyword = command.substring(5);
                    if (keyword.isBlank()) {
                        ui.showEmptyError("find");
                    } else {
                        ui.showMatchList(tasks.findKeyword(keyword));
                    }
                } catch (Exception e) {
                    ui.showEmptyError("find");
                }
                break;

            default:
                ui.showUnknownCommand();
                break;
        }
    }
}
