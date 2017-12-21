package br.com.assertsistemas.practice.deltaspike.jpa.annotation;

import javax.inject.Qualifier;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Qualifier
@Retention( RetentionPolicy.RUNTIME )
@Target( { ElementType.FIELD , ElementType.TYPE , ElementType.PARAMETER} )
public @interface Deleted {
}
