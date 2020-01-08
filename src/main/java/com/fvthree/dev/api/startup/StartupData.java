package com.fvthree.dev.api.startup;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupData  implements CommandLineRunner {
    private static final Logger logger = LogManager.getLogger(StartupData.class);
    @Override
    public void run(String... args) throws Exception {
        logger.warn("starting...");
    }
}
