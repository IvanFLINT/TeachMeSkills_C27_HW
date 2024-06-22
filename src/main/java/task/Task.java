package task;

import java.util.ArrayList;
import java.util.List;

public class Task {

    private String name;
    private List<SubTask> subTasks;

    public Task(String name) {
        this.name = name;
        this.subTasks = new ArrayList<>();
    }

    public void addSubTask(SubTask subTask) {
        subTasks.add(subTask);
    }

    public void execute() {
        System.out.println("Выполнение задачи: " + name);
        for (SubTask subTask : subTasks) {
            subTask.execute();
        }
    }
}
