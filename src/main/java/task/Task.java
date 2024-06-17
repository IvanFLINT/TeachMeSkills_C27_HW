package task;

public class Task {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void execute() {
        System.out.println("Выполнение задачи: " + name);
    }
}
