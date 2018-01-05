package ru.rsatu.core.annotations;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.logging.log4j.Logger;

public class AnnotationHandler implements AnnotationHandlerInterface {
    private Logger logger = null;
    private Method method = null;
    public AnnotationHandler(Logger l, Method m){
        logger = l;
        method = m;
    }

    public void process(Object[] args) {
        logger.info(String.format("logged call of '%s' method with args: '%s'", method.getName(), Arrays.toString(args)));
    }

    public void postprocess(Object result) {
        logger.info(String.format("End call of '%s' method with result: '%s'", method.getName(), result != null ? result.toString() : "null"));
    }
}
