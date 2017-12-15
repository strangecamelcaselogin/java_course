package ru.rsatu.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogInvocation implements InvocationHandler{
    private Object originalObject;
    private Class<? extends Annotation> triggerAnnotation;

    private static final Logger logger = LogManager.getLogger();

    public LogInvocation(Object originalObject, Class<? extends Annotation> triggerAnnotation) {
        this.originalObject = originalObject;  // сохраним оригинальный объект
        this.triggerAnnotation = triggerAnnotation ;  // и ссылку на класс аннотации, которая нас интересует
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // достанем оригинальный метод (прокси метод не имеет аннотаций)
        Method methodToCall = this.originalObject.getClass().getMethod(method.getName(), method.getParameterTypes());

        if (methodToCall.isAnnotationPresent(this.triggerAnnotation)) {
            logger.info(String.format("logged call of '%s' method", method.getName()));
        }
        return method.invoke(this.originalObject, args);
    }
}
