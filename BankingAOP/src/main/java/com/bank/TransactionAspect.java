package com.bank;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionAspect {

    @Before("execution(* com.bank.BankAccount.deposit(..)) || " +
            "execution(* com.bank.BankAccount.withdraw(..))")
    public void logBeforeTransaction() {
        System.out.println("[AOP] Transaction started.");
    }

    @AfterReturning(
        "execution(* com.bank.BankAccount.deposit(..)) || " +
        "execution(* com.bank.BankAccount.withdraw(..))"
    )
    public void logSuccessfulTransaction() {
        System.out.println(
            "[AOP] Transaction completed successfully."
        );
    }

    @AfterThrowing(
        pointcut = "execution(* com.bank.BankAccount.deposit(..)) || " +
                   "execution(* com.bank.BankAccount.withdraw(..))",
        throwing = "exception"
    )
    public void logFailedTransaction(
            IllegalArgumentException exception) {
        System.out.println(
            "[AOP] Transaction failed: " + exception.getMessage()
        );
    }
}