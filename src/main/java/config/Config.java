package config;

import executor.Executor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import task.SubTask;
import task.Task;

import java.util.Arrays;
import java.util.List;

@Configuration
public class Config {

    @Bean
    public Task task1() {
        Task task1 = new Task("№ 1");
        new SubTask("первой подзадачи", task1);
        new SubTask("вторай подзадачи", task1);
        return task1;
    }

    @Bean
    public Task task2() {
        Task task2 = new Task("№ 2");
        new SubTask("первоя подзадачи", task2);
        new SubTask("вторая подзадачи", task2);
        return task2;
    }

    @Bean
    public Task task3() {
        Task task3 = new Task("№ 3");
        new SubTask("первой подзадачи", task3);
        new SubTask("вторай подзадачи", task3);
        new SubTask("третьей подзадачи", task3);
        new SubTask("четвертой подзадачи", task3);
        return task3;
    }

    @Bean
    public List<Task> tasks() {
        return Arrays.asList(task1(), task2(), task3());
    }

    @Bean
    public Executor taskExecutor() {
        return new Executor(tasks());
    }
}
