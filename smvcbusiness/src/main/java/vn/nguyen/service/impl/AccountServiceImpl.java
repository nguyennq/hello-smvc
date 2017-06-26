package vn.nguyen.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.nguyen.entity.Account;
import vn.nguyen.entity.Role;
import vn.nguyen.repository.AccountRepository;
import vn.nguyen.repository.IRoleRepository;
import vn.nguyen.request.ProfileForm;
import vn.nguyen.request.RegisterForm;
import vn.nguyen.service.AccountService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by quocnguyen on 22/12/2015.
 */
@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private IRoleRepository iRoleRepository;


//    public Account findFirstByUserName(RegisterForm registerForm) {
//        return accountRepository.findFirstByUsername(registerForm.getUsername());
//    }

    public Account findFirstByUserName(String userName) {
        return accountRepository.findFirstByUsername(userName);
    }


    public Account findFirstByEmail(String email) {
        return null;
    }

//    public Account convertRegisterFormToAccount(RegisterForm registerForm) {
//        return null;
//    }
    public Account convertRegisterFormToAccount(RegisterForm registerForm) {
        Account account = new Account();

//        registerForm = encryptPasswordOfRegisterForm(registerForm);

        account.setUsername(registerForm.getUsername());
        account.setPassword(registerForm.getPassword());
        account.setCity(registerForm.getCity());
        account.setCountry(registerForm.getCountry());
        account.setEmail(registerForm.getEmail());
        account.setFirstName(registerForm.getFirstName());
        account.setLastName(registerForm.getLastName());
        account.setPhonenumber(registerForm.getPhonenumber());

        account = createAccountWithRoleUser(account);

        return account;
    }
    private Account createAccountWithRoleUser(Account account) {
        account.setRoles(getRoleOfUser());
        return account;
    }
    private Set<Role> getRoleOfUser() {
        Set<Role> roles = new HashSet<Role>();
        roles.add(iRoleRepository.findByName("user"));
        return roles;
    }

    public ProfileForm getProfileFormFromUsername(String username) {
        return null;
    }

    public Account convertProfileFormToAccount(ProfileForm profileForm) {
        return null;
    }


    public Account saveAccount(RegisterForm registerForm) {
        Account account = new Account();
        account.setFirstName(registerForm.getFirstName());
        return accountRepository.save(account);
    }

    public Account updateAccount(ProfileForm profileForm) {
        return null;
    }

    public Page<Account> findAll(Pageable pageable) {
        return null;
    }

    public List<Account> findAll() {
        return null;
    }

    public Account findOne(int id) {
        return null;
    }

    public void delete(int id) {

    }

    public Account save(Account account) {
        return null;
    }
}
