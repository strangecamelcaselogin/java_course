package ru.rsatu.core.annotations;

import java.lang.reflect.Method;

import org.apache.logging.log4j.Logger;


public interface AnnotationHandlerInterface {
    public void process(Logger l, Method m);
}
