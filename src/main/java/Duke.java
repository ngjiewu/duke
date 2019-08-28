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
        int counter = 0;

        while (true) {
            Scanner in = new Scanner(System.in);
            String command = in.nextLine();
            String[] token = command.split(" ");

            if (token[0].equals("list")) {
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < counter; i++) {
                    System.out.println(i+1 + "." + tasks[i].toString());
                }
            } else if (token[0].equals("done")) {
                int getIndex = Integer.parseInt(token[1]) - 1;
                tasks[getIndex].markAsDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println(tasks[getIndex].toString());
            } else if (token[0].equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            } else {
                tasks[counter] = new Task(command);
                System.out.println("added: " + command);
                counter++;
            }
        }
    }
}