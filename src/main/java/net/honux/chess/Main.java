package net.honux.chess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Main.class);
        logger.info("Hello Logback 1");
        logger.debug("Hello Logback 2");
        logger.warn("Hello Logback 3");

        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        System.out.println("Working Directory = " + new File(".").getAbsolutePath());

    }
}
