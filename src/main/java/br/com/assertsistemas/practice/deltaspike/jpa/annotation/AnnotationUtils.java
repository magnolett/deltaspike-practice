package br.com.assertsistemas.practice.deltaspike.jpa.annotation;

import javax.enterprise.util.AnnotationLiteral;

public class AnnotationUtils {

    public static final AnnotationLiteral< Saved > SAVED = new AnnotationLiteral< Saved >() {
        private static final long serialVersionUID = -5566803372794805548L;
    };

    public static final AnnotationLiteral< Edited > EDITED = new AnnotationLiteral< Edited >() {
        private static final long serialVersionUID = 3384073999053831652L;
    };

    public static final AnnotationLiteral< Deleted > DELETED = new AnnotationLiteral< Deleted >() {
        private static final long serialVersionUID = 5090601369352969880L;
    };
}
