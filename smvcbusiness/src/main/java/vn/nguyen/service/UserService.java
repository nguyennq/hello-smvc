package vn.nguyen.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.nguyen.entity.User;
import vn.nguyen.request.UserRequest;

import java.util.List;

/**
 * Created by quocnguyen on 24/12/2015.
 */
public interface UserService {
    User findById(String userid);

    User findByName(String name);

    User saveUser(UserRequest userRequest);

    User updateUser(UserRequest userRequest);

    void deleteUserById(String userid);

    List<User> findAllUsers();
    Page<User> listAllUser(Pageable pageable);

    void deleteAllUsers();

    public boolean isUserExist(UserRequest userRequest);
}
