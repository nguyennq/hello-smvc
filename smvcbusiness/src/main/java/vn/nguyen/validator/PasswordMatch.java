package vn.nguyen.validator;



import vn.nguyen.validator.implement.PasswordMatchValidatorImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;

@Retention(RetentionPolicy.RUNTIME)
@Target(TYPE)
@Constraint(validatedBy = PasswordMatchValidatorImpl.class)
@Documented
public @interface PasswordMatch {
    String message() default "register invalid, password and confirm password not match";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
