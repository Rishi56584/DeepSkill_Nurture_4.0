package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String userName = "Alice";
        int loginAttempts = 3;

        logger.info("User {} has logged in successfully.", userName);
        logger.warn("User {} has attempted to log in {} times.", userName, loginAttempts);
        logger.error("Login failed for user {} after {} attempts.", userName, loginAttempts);
    }
}

