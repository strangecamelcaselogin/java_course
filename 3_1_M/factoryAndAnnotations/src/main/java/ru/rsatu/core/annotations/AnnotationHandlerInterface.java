package ru.rsatu.core.annotations;

import java.lang.reflect.Method;

import org.apache.logging.log4j.Logger;


public interface AnnotationHandlerInterface {
    void process(Object[] args);
    void postprocess(Object result);
}
