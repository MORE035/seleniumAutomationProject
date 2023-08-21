package org.sap.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.sap.enums.AuthorNames;
import org.sap.enums.CategoryType;

@Retention(RUNTIME)
@Target(METHOD)
public @interface FrameWorkAnnotation {
 public AuthorNames[] autherName();
 public CategoryType[] category();

}
