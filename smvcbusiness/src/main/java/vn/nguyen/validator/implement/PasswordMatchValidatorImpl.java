package vn.nguyen.validator.implement;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import vn.nguyen.request.RegisterForm;
import vn.nguyen.utils.LOG;
import vn.nguyen.validator.PasswordMatch;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@Scope("prototype")
public class PasswordMatchValidatorImpl implements ConstraintValidator<PasswordMatch,RegisterForm> {
//    @Override
    public void initialize(PasswordMatch registerValidator) {
        LOG.debug("register validator initialize");
    }

//    @Override
    public boolean isValid(RegisterForm registerForm, ConstraintValidatorContext constraintValidatorContext) {
        if(checkPasswordAndConfirmPassword(registerForm.getPassword(),registerForm.getRePassword())){
            return true;
        }
        return false;
    }

    private boolean checkPasswordAndConfirmPassword(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }
}
