package io.robusta.fora.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;


@Target(ElementType.METHOD)
public @interface Slow {

	long value();
	
	String author() default "";
	
}
