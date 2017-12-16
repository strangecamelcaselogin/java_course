package ru.rsatu.core.annotations;

import java.lang.reflect.Method;

import org.apache.logging.log4j.Logger;

public class AnnotationHandler implements AnnotationHandlerInterface {
    public void process(Logger l, Method m) {
        l.info(String.format("logged call of '%s' method", m.getName()));
    }
}
