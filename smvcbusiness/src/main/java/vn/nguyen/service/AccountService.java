package vn.nguyen.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.nguyen.entity.Account;
import vn.nguyen.request.ProfileForm;
import vn.nguyen.request.RegisterForm;

import java.util.List;

/**
 * Created by quocnguyen on 22/12/2015.
 */
public interface AccountService {



    Account findFirstByUserName(String userName);
    Account findFirstByEmail(String email);
//    Account convertRegisterFormToAccount(RegisterForm registerForm);
    ProfileForm getProfileFormFromUsername(String username);
//    Account convertProfileFormToAccount(ProfileForm profileForm);
    Account saveAccount(RegisterForm registerForm);
    Account updateAccount(ProfileForm profileForm);
    Page<Account> findAll(Pageable pageable);
    List<Account> findAll();
    Account findOne(int id);
    void delete(int id);
    Account save(Account account);


//
//    Account findById(String id);
//
//    Account findByUserName(String name);
//
//    void saveAccount(Account account);
//
//    void updateAccount(Account account);
//
//    void deleteAccountById(long id);


//    List<User> findAllUsers();
//
//    void deleteAllUsers();
//
//    public boolean isUserExist(User user);
}
