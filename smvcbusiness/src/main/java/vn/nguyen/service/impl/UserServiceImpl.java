package vn.nguyen.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.nguyen.entity.User;
import vn.nguyen.exception.UserException;
import vn.nguyen.repository.UserRepository;
import vn.nguyen.request.UserRequest;
import vn.nguyen.service.UserService;
import vn.nguyen.utils.ErrorCodeConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by quocnguyen on 24/12/2015.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MessageSource messageSource;
    private static final AtomicLong counter = new AtomicLong();

    private List<User> users;


    public User findById(String userid) {
        return userRepository.findOne(userid);
    }

    public User findByName(String name) {
        users = userRepository.findAll();
        for(User user : users){
            if(user.getName().equalsIgnoreCase(name)){
                return user;
            }
        }
        return null;
    }

    public User saveUser(UserRequest userRequest) {
        if (isUserExist(userRequest)){
            throw new UserException(ErrorCodeConstants.ERROR_USER_EXIST,messageSource.getMessage(ErrorCodeConstants.ERROR_USER_EXIST
            ,null,LocaleContextHolder.getLocale()));
        }
        User user = getUser(userRequest);

        return userRepository.save(user);

    }

    private User getUser(UserRequest userRequest) {
        User user = new User();
//        user.setUserid(userRequest.getUserId());
        user.setAge(userRequest.getAge());
        user.setName(userRequest.getName());
        user.setSalary(userRequest.getSalary());
        return user;
    }

    public User updateUser(UserRequest userRequest) {
        User user = userRepository.findOne(userRequest.getUserId());
        if(user == null){
            throw new UserException(ErrorCodeConstants.ERROR_USER_NOT_FOUND,messageSource.getMessage(ErrorCodeConstants.ERROR_USER_NOT_FOUND,null, LocaleContextHolder.getLocale()));
        }
        user.setUserid(userRequest.getUserId());
        user.setName(userRequest.getName());
        user.setSalary(userRequest.getSalary());
        user.setAge(userRequest.getAge());
        return userRepository.save(user);
    }

    public void deleteUserById(String userid) {

    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public Page<User> listAllUser(Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable);
        return users;
    }

    public void deleteAllUsers() {

    }

    public boolean isUserExist(UserRequest userRequest) {
        return findByName(userRequest.getName())!=null;
    }


}
