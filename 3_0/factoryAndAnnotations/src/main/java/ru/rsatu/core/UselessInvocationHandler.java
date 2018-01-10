package ru.rsatu.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.rsatu.core.annotations.AnnotationHandler;
import ru.rsatu.core.annotations.MetaAnnotation;

public class UselessInvocationHandler implements InvocationHandler{
    private Object originalObject;
    // Мета аннотация, которая является критерием исполнения наших хендлеров для методов
    private Class<MetaAnnotation> metaAnnotation = MetaAnnotation.class;

    private static final Logger logger = LogManager.getLogger();  // объект логгера

    public UselessInvocationHandler(Object originalObject) {
        this.originalObject = originalObject;  // сохраним оригинальный объект
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // достанем оригинальный метод (прокси метод не имеет аннотаций)
        Method methodToCall = this.originalObject.getClass().getMethod(method.getName(), method.getParameterTypes());

        Object result = null;

        // просмотрим все аннотации этого метода
        for (Annotation a: methodToCall.getAnnotations()) {
            Class<? extends Annotation> annotationType = a.annotationType();

            // если же аннотация метода сама зааннотирована
            if (annotationType != null) {
                // и если эта наша Мета аннотация
                if (annotationType.isAnnotationPresent(metaAnnotation)) {
                    // получим имя обработчика, указанное в мета аннотации
                    String annotationHandlerName = annotationType.getAnnotation(metaAnnotation).handlerName();

                    AnnotationHandler handler = (AnnotationHandler) Class
                            .forName(annotationHandlerName)
                            .getDeclaredConstructor(Logger.class, Method.class)
                            .newInstance(logger, methodToCall);

                    handler.process(args);  // вызовем соответствующий обработчик

                    result = method.invoke(this.originalObject, args);  // наконец вызовем и сам метод

                    handler.postprocess(result);
                }
            }
        }

        if (result == null) {
            result = method.invoke(this.originalObject, args);  // наконец вызовем и сам метод
        }

        return result;
    }
}
