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

        String[] tasks = new String[100];
        int counter = 0;
        while (true) {
            Scanner in = new Scanner(System.in);
            String command = in.nextLine();
            if (command.equals("list")) {
                for (int i = 0; tasks[i] != null; i++) {
                    System.out.println(i+1 + ". " + tasks[i]);
                }
            } else if (command.equals("bye")){
                System.out.println("Bye. Hope to see you again soon!");
                break;
            } else {
                tasks[counter] = command;
                System.out.println("added: " + command);
                counter++;
            }
        }
    }
}