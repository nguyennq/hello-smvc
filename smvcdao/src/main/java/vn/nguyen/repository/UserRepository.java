package vn.nguyen.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.nguyen.entity.User;

/**
 * Created by quocnguyen on 24/12/2015.
 */
public interface UserRepository extends JpaRepository<User,String> {

//    Page<User> findByUser(Pageable pageable);
}
