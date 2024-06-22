import config.Config;
import executor.Executor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Executor taskExecutor = context.getBean(Executor.class);
        taskExecutor.executeAll();
    }
}
