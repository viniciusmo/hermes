package com.hermes.model.orm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation that can be applied to entity classes to set various options.
 * These options are described in the {@link Entity} documentation.
 */
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
	String name() default "";

	boolean primaryKey() default false;

	boolean inverse() default false;
}
