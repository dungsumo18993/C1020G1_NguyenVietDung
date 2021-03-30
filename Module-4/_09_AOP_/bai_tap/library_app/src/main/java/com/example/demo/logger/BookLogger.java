package com.example.demo.logger;

import com.example.demo.controller.BookController;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

@Aspect
public class BookLogger {
        private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(BookController.class);

    @After("execution(* com.example.demo.controller.BookController.borrow(..))")
    public void afterBorrow(JoinPoint joinPoint) {
        LOGGER.info("Book [" + joinPoint.getArgs()[0] + "] borrowed.");
    }

    @After("execution(* com.example.demo.controller.BookController.giveBackBook(..)))")
    public void afterReturning(JoinPoint joinPoint){
        LOGGER.info("Book [" + joinPoint.getArgs()[0] + "] returned.");
    }
}
