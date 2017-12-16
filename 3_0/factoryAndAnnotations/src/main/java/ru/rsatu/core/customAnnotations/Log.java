package ru.rsatu.core.customAnnotations;

import java.lang.annotation.*;

@MetaAnnotation(handlerName = "ru.rsatu.core.customAnnotations.AnnotationHandler")
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Log {}
