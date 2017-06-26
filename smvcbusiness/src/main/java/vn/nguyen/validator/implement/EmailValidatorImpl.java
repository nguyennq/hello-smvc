package vn.nguyen.validator.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.nguyen.entity.Account;
import vn.nguyen.repository.AccountRepository;
import vn.nguyen.utils.LOG;
import vn.nguyen.validator.UniqueEmail;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class EmailValidatorImpl implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    private AccountRepository accountRepository;

//    @Override
    public void initialize(UniqueEmail uniqueEmail) {
        LOG.debug("email validator initialize");
    }

//    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return !checkEmailExist(email);
    }

    private boolean checkEmailExist(String email) {
        Account account = accountRepository.findFirstByEmail(email);
        if (account == null) {
            return false;
        }
        return true;
    }

}
