package com.mnov34.quiz.services;

/**
 * @author Maël NOUVEL <br>
 * 01/2025
 **/
public interface LoggingService {
    void info(String message, Object... params);
    void debug(String message, Object... params);
    void error(String message, Throwable throwable);
    void warn(String message, Object... params);
}