package ru.rsatu.core.annotations;

import java.lang.annotation.*;

@MetaAnnotation(handlerName = "ru.rsatu.core.annotations.AnnotationHandler")
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Log {}
