package com.karpunets.analyzer.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation Filler is used for automate work methods that are in {@link com.karpunets.fillers.RandomGenerator}.
 *
 * @author Karpunets
 * @since 24.11.2016
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Filler {

}
