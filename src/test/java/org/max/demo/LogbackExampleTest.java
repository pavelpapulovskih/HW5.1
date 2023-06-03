package org.max.demo;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackExampleTest {

    private static final Logger logger
            = LoggerFactory.getLogger(LogbackExampleTest.class);

    @Test
    void simpleExampleTest() {
        logger.info("log String value to console");
    }
}
