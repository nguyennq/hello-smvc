package vn.nguyen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.nguyen.entity.Account;

/**
 * Created by quocnguyen on 22/12/2015.
 */
public interface AccountRepository extends JpaRepository<Account,String> {
    Account findFirstByUsername(String userName);
    Account findFirstByEmail(String email);
}
