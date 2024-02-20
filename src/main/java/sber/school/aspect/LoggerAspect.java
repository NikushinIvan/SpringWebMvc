package sber.school.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggerAspect {

    private final Logger serviceLogger = Logger.getAnonymousLogger();

    @After("@annotation(Logging)")
    public void loggingExecuteMethod(JoinPoint joinPoint) {
        serviceLogger.info("Метод " + joinPoint.getSignature().toShortString() + " выполнен");
    }
}
