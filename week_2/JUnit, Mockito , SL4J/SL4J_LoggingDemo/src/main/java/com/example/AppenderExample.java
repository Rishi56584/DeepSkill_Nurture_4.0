package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppenderExample {
    private static final Logger logger = LoggerFactory.getLogger(AppenderExample.class);

    public static void main(String[] args) {
        logger.debug("Debug message: App is starting");
        logger.info("Info message: Running AppenderExample");
        logger.warn("Warning message: Low disk space");
        logger.error("Error message: Null pointer exception");
    }
}
