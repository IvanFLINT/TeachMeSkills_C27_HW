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
        SubTask subTask1 = new SubTask("первой подзадача", task1);
        SubTask subTask2 = new SubTask("вторай подзадача", task1);
        return new Task("№ 1") {
            @Override
            public void execute() {
                super.execute();
                subTask1.execute();
                subTask2.execute();
            }
        };
    }

    @Bean
    public Task task2() {
        Task task2 = new Task("№ 2");
        SubTask subTask1 = new SubTask("Первоя подзадача", task2);
        SubTask subTask2 = new SubTask("Вторая подзадача", task2);
        return new Task("№ 2") {
            @Override
            public void execute() {
                super.execute();
                subTask1.execute();
                subTask2.execute();
            }
        };
    }
    @Bean
    public Task task3() {
        Task task3 = new Task("№ 3");
        SubTask subTask1 = new SubTask("первой подзадача", task3);
        SubTask subTask2 = new SubTask("вторай подзадача", task3);
        SubTask subTask3 = new SubTask("третьей подзадача", task3);
        SubTask subTask4 = new SubTask("четвертой подзадача", task3);
        return new Task("№ 3") {
            @Override
            public void execute() {
                super.execute();
                subTask1.execute();
                subTask2.execute();
                subTask3.execute();
                subTask4.execute();
            }
        };
    }

    @Bean
    public List<Task> tasks() {
        return Arrays.asList(task1(), task2(),task3());
    }

    @Bean
    public Executor taskExecutor() {
        return new Executor(tasks());
    }
}
