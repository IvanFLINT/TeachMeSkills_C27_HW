package studentGroop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"connect", "studentGroop"})
public class StudentGroupApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentGroupApplication.class, args);
    }
}
