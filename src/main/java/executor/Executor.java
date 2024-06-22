package executor;

import task.Task;

import java.util.List;

public class Executor {
    private List<Task> tasks;

    public Executor(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void executeAll() {
        for (Task task : tasks) {
            task.execute();
        }
    }
}
