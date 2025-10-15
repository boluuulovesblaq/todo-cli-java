package version1;
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
}