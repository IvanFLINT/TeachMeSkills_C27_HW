package task;

public class SubTask extends Task{
    private Task homeTask;

    public SubTask(String name, Task homeTask) {
        super(name);
        this.homeTask = homeTask;
    }

    @Override
    public void execute() {
        System.out.println("Выполнение " + getName() + " задачи: " + homeTask.getName());
    }
}
