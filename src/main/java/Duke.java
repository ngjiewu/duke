import java.util.Scanner;

/**
 * The Duke class is the main class of the entire programme.
 */
public class Duke {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public static void main(String[] args) {
        new Duke("C:\\Users\\JieWu\\Desktop\\duke\\data\\duke.txt").run();
    }

    /**
     * Loads the essential components of the entire programme.
     * @param filePath name of the location in the file system
     */
    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (DukeException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    /**
     * Main function of the entire programme that controls how the whole programme will be run.
     */
    public void run() {
        ui.showWelcome();
        Scanner input = new Scanner(System.in);
        String command = input.nextLine();
        while (!command.equals("bye")) {
            Parser.execute(command, ui, tasks);
            command = input.nextLine();
        }
        try {
            storage.saveFile(tasks);
        } catch (DukeException e) {
            e.printStackTrace();
        }
        ui.showExit();
    }
}