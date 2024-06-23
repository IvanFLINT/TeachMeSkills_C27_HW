package task;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class ServiceAspect {

    @Before("execution(public String Service.method*(*))")
    public void nameCheck(JoinPoint joinPoint) {
        String arg = (String) joinPoint.getArgs()[0];
        if (arg.equals("Ivan")) {
            System.out.println("Hello!! " + arg);
        } else {
            System.out.println("Wrong name");
        }
    }
}
