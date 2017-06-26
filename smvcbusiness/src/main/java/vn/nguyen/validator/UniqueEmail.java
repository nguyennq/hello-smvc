package vn.nguyen.validator;



import vn.nguyen.validator.implement.EmailValidatorImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Retention(RetentionPolicy.RUNTIME)
@Target( { METHOD, FIELD, ANNOTATION_TYPE})
@Constraint(validatedBy = EmailValidatorImpl.class)
@Documented
public @interface UniqueEmail {

    String message() default "email invalid or existed on database";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
