import java.util.*;
import java.io.*;

public class HandleFile {
    private static final String filePath = ".\\data\\duke.txt";

    public static void openFile(ArrayList<Task> tasks) throws DukeException {
        try {
            FileReader file = new FileReader(filePath);
            BufferedReader br = new BufferedReader(file);
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(" \\| ");
                switch(tokens[0]) {
                    case "T":
                        Task todo = new Todo(tokens[2]);
                        if (tokens[1].equals("1")) todo.markAsDone();
                        tasks.add(todo);
                        break;

                    case "D":
                        Task deadline = new Deadline(tokens[2],tokens[3]);
                        if (tokens[1].equals("1")) deadline.markAsDone();
                        tasks.add(deadline);
                        break;

                    case "E":
                        Task event = new Event(tokens[2],tokens[3]);
                        if (tokens[1].equals("1")) event.markAsDone();
                        tasks.add(event);
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            throw new DukeException("Duke.txt file not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateFile(ArrayList<Task> tasks) throws DukeException {
        try {
            FileWriter fw = new FileWriter(filePath);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Task task : tasks) {
                bw.write(task.writeLine());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            throw new DukeException("File is not found!");
        }
    }
}