import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TodoApp app = new TodoApp(); // create object
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Command (add/list/del/exit/save/load): ");
            System.out.print("> ");
            String line = scanner.nextLine().trim();

            if (line.startsWith("add ")) {
                app.add(line.substring(4).trim());
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
            }else if (line.equalsIgnoreCase("save")) {
                     app.saveToFile("todos.txt");
                } else if (line.equalsIgnoreCase("load")) {
                           app.loadFromFile("todos.txt");
                        } else if (line.equals("exit")) {
                break;
            } else {
                System.out.println("unknown command.");
            }
        }
    }
}
