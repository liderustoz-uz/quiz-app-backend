package uz.bakhromjon.ustoztalim.annotations;

import jakarta.validation.Constraint;
import uz.bakhromjon.ustoztalim.constraint.CollectionSizeValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {CollectionSizeValidator.class})
@Target({METHOD, FIELD, ANNOTATION_TYPE, PARAMETER, CONSTRUCTOR})
@Retention(RUNTIME)
public @interface CollectionSize {
}
