package evgeny_borisov.spring_puzzlers;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author Sergei Aleshchenko
 */
@Component
@Aspect
public class PayInformationAspect {

    @Pointcut("execution(* evgeny_borisov.spring_puzzlers..*.pay*(..))")
    public void allPayMethods() {
        System.out.println("PayInformationAspect.allPayMethods()");
    }


    @After("allPayMethods()")
    public void sendMailToFedorov() {
        System.out.println("Еще билет продали");
    }
}
