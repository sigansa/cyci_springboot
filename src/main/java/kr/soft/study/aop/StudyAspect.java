package kr.soft.study.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class StudyAspect {

    //execution( 접근제어자 패키지.클래스명.메소드명(매게변수 타입)
    @Before("execution(* kr.soft.study.api.StudyController.*(..))")
    public void beforeAPi(JoinPoint joinPoint) {
        log.info("================== ✅ BEFORE =====================");
        log.info("type-name: {}", joinPoint.getSignature().getDeclaringTypeName());
        log.info("getName: {}", joinPoint.getSignature().getName());
    }

    @After("execution(* kr.soft.study.api.StudyController.*(..))")
    public void afterAPi(JoinPoint joinPoint) {
        log.info("================== ✅ AFTER =====================");
        log.info("type-name: {}", joinPoint.getSignature().getDeclaringTypeName());
        log.info("getName: {}", joinPoint.getSignature().getName());
    }

    @AfterReturning("execution(* kr.soft.study.api.StudyController.*(..))")
    public void afterReturningAPi(JoinPoint joinPoint) {
        log.info("================== ✅ AFTER-RETURNING =====================");
        log.info("type-name: {}", joinPoint.getSignature().getDeclaringTypeName());
        log.info("getName: {}", joinPoint.getSignature().getName());
    }

    @AfterThrowing(value = "execution(* kr.soft.study.api.StudyController.*(..))",
    throwing = "exception")
    public void afterTrowingAPi(JoinPoint joinPoint, Exception exception) {
        log.info("================== ❌ AFTER-THROWING =====================");
        log.info("type-name: {}", joinPoint.getSignature().getDeclaringTypeName());
        log.info("getName: {}", joinPoint.getSignature().getName());
    }
}
