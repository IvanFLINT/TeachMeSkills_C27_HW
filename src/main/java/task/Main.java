package task;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        Service service = context.getBean("service", Service.class);
        service.method1("Ivan");
        service.method2("Viktor");
    }
}
