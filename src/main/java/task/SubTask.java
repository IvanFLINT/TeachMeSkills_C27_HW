package task;

public class SubTask{
    private String name;
    private Task task;

    public SubTask(String name, Task task) {
        this.name = name;
        this.task = task;
    }

    public void execute() {
        System.out.println(" Выполнение " + name);
    }
}
