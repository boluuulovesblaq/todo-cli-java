import java.util.ArrayList;
import java.util.Scanner;

/*
 Simple CLI Todo app.
 - Uses ArrayList (dynamic array) to store items.
 - Logic separated into instance methods to make unit testing possible.
*/

public class TodoApp {
    private final ArrayList<String> todos = new ArrayList<>(); // dynamic array

    // add an item
    public void add(String item) {
        if (item == null || item.trim().isEmpty()) return;
        todos.add(item.trim());
    }

    // list items (1-based index)
    public String list() {
        if (todos.isEmpty()) return "No todos.";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < todos.size(); i++) {
            sb.append(String.format("%d. %s%n", i + 1, todos.get(i)));
        }
        return sb.toString().trim();
    }

    // remove by 1-based index, returns true if removed
    public boolean remove(int index) {
        if (index < 1 || index > todos.size()) return false;
        todos.remove(index - 1);
        return true;
    }

    // CLI glue (keeps I/O separate from logic)
    public static void main(String[] args) {
        TodoApp app = new TodoApp();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Todo CLI — commands: add <text> | list | del <num> | exit");
        while (true) {
            System.out.print("> ");
            String line = scanner.nextLine().trim();
            if (line.equalsIgnoreCase("exit")) break;
            if (line.startsWith("add ")) {
                app.add(line.substring(4));
                System.out.println("added.");
            } else if (line.equals("list")) {
                System.out.println(app.list());
            } else if (line.startsWith("del ")) {
                try {
                    int idx = Integer.parseInt(line.substring(4).trim());
                    System.out.println(app.remove(idx) ? "deleted." : "bad index.");
                } catch (NumberFormatException e) {
                    System.out.println("invalid number.");
                }
            } else {
                System.out.println("commands: add <text> | list | del <num> | exit");
            }
        }
        scanner.close();
        System.out.println("bye.");
    }
}
