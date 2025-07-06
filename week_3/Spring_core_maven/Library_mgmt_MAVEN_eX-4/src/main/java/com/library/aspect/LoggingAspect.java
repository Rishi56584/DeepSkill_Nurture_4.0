package com.library.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.library.service.BookService.addBook(..))")
    public void beforeAddBook() {
        System.out.println("==> [AOP] Before adding book - LoggingAspect running...");
    }

    @After("execution(* com.library.service.BookService.addBook(..))")
    public void afterAddBook() {
        System.out.println("==> [AOP] After adding book - LoggingAspect running...");
    }
}
