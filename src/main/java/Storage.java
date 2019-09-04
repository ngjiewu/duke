import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Storage {
    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<Task> load() throws DukeException {
        ArrayList<Task> tasks = new ArrayList<>();
        try {
            FileReader file = new FileReader(filePath);
            BufferedReader br = new BufferedReader(file);
            String line;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(" \\| ");
                switch(tokens[0]) {
                    case "T":
                        Task todo = new Todo(tokens[2]);
                        if (tokens[1].equals("1")) todo.markAsDone();
                        tasks.add(todo);
                        break;

                    case "D":
                        LocalDateTime dDateTime = LocalDateTime.parse(tokens[3], formatter);
                        Task deadline = new Deadline(tokens[2], dDateTime);
                        if (tokens[1].equals("1")) deadline.markAsDone();
                        tasks.add(deadline);
                        break;

                    case "E":
                        LocalDateTime eDateTime = LocalDateTime.parse(tokens[3], formatter);
                        Task event = new Event(tokens[2], eDateTime);
                        if (tokens[1].equals("1")) event.markAsDone();
                        tasks.add(event);
                        break;
                }

            }
            return tasks;
        } catch (Exception e) {
            throw new DukeException(e.getMessage());
        }
    }

    public void saveFile(TaskList tasks) throws DukeException {
        try {
            FileWriter fw = new FileWriter(filePath);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < tasks.size(); i++) {
                bw.write(tasks.get(i).writeLine());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            throw new DukeException("Error encountered when saving file.");
        }
    }
}