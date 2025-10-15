import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TodoApp {
    private final ArrayList<String> todos = new ArrayList<>();

    public void add(String item) {
        if (item == null || item.trim().isEmpty()) return;
        todos.add(item.trim());
    }

    public String list() {
        if (todos.isEmpty()) return "No todos.";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < todos.size(); i++) {
            sb.append(String.format("%d. %s%n", i + 1, todos.get(i)));
        }
        return sb.toString().trim();
    }

    public boolean remove(int index) {
        if (index < 1 || index > todos.size()) return false;
        todos.remove(index - 1);
        return true;
    }

    public int count() {
        int sum = todos.size();
        return sum;
    }

    public void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String todo : todos) {
                writer.write(todo);
                writer.newLine();
            }
            System.out.println("Todos saved.");
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }  
    }

    // load todos from a file
    public void loadFromFile(String filename) {
        todos.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
           String line;
            while ((line = reader.readLine()) != null) {
                todos.add(line.trim());
            }
            System.out.println("Todos loaded.");
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }
}
