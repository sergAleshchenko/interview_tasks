package transactional.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author Sergei Aleshchenko
 */

@Component
@Aspect
// What code need to be here
public class CallTracker {

    @Pointcut("within(transactional.service.*) || within(transactional.repository.*)")
    public void logMethodPointCut() {

    }

    @Around("logMethodPointCut()")
    public Object logBeforeMethodCall(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        // Before
        String methodName = proceedingJoinPoint.getSignature().getName();
        System.out.println("Method start: " + methodName);

        // Calling of your method
        Object returnValue = proceedingJoinPoint.proceed();
        System.out.println(returnValue); // Will be null now

        // After the method executed
        System.out.println("Method completed: " + methodName);


        return returnValue;
    }
}
