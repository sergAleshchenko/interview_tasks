package AOP;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author Sergei Aleshchenko
 */
@Aspect
public class GreetingAspect {
    @Pointcut("execution(* AOP.Main.printName(String))")
    public void greeting() {
    }

    @Before("greeting()")
    public void beforeAdvice() {
        System.out.print("Hello ");
    }
}
