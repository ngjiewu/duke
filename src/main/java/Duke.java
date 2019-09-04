import java.util.Scanner;

public class Duke {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public static void main(String[] args) {
        new Duke("C:\\Users\\JieWu\\Desktop\\duke\\data\\duke.txt").run();
    }

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

    public void run () {
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