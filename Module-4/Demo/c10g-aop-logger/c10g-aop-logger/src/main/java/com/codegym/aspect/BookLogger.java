package com.codegym.aspect;

import com.codegym.controller.BookController;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;

@Aspect
public class BookLogger {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(BookController.class);

    @After(value = "execution(public * com.codegym.controller.BookController.borrowBook(..))")
    public void afterBorrow(JoinPoint joinPoint) {
        LOGGER.info("Book [" + joinPoint.getArgs()[0] + "] borrowed.");
    }
}
