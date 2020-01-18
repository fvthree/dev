package com.fvthree.dev.api.startup;

import com.fvthree.dev.api.rest.user.repositories.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupData  implements CommandLineRunner {
    private static final Logger logger = LogManager.getLogger(StartupData.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        logger.warn("starting...");
    }
}
