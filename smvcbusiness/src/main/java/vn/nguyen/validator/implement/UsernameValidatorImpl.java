package vn.nguyen.validator.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.nguyen.entity.Account;
import vn.nguyen.service.AccountService;
import vn.nguyen.utils.LOG;
import vn.nguyen.validator.UniqueUsername;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UsernameValidatorImpl implements ConstraintValidator<UniqueUsername, String> {

    @Autowired
    private AccountService iAccountService;

//    @Override
    public void initialize(UniqueUsername uniqueUsername) {
        LOG.debug("username validator initialize");
    }

//    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return !checkUsername(s);
    }

    private boolean checkUsername(String username) {
        Account account = iAccountService.findFirstByUserName(username);
        if (account == null) {
            return false;
        }
        return true;
    }
}
