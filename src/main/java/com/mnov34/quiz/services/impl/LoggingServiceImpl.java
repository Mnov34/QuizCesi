package com.mnov34.quiz.services.impl;

import com.mnov34.quiz.services.LoggingService;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Maël NOUVEL <br>
 * 01/2025
 **/
public class LoggingServiceImpl implements LoggingService {

    private static class Holder {
        private static final LoggingServiceImpl INSTANCE = new LoggingServiceImpl();
    }

    public static LoggingServiceImpl getInstance() {
        return Holder.INSTANCE;
    }

    private final Logger logger;

    public LoggingServiceImpl() {
        this.logger = LoggerFactory.getLogger(LoggingServiceImpl.class);
    }

    public Logger getLogger(Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }

    @Override
    public void info(String message, Object... params) {
        logger.info(message, params);
    }

    @Override
    public void debug(String message, Object... params) {
        logger.debug(message, params);
    }

    @Override
    public void warn(String message, Object... params) {
        logger.warn(message, params);
    }

    @Override
    public void error(String message, Throwable throwable) {
        logger.error(message, throwable);
    }
}
