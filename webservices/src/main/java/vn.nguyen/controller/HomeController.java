package vn.nguyen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import vn.nguyen.entity.User;
import vn.nguyen.exception.UserException;
import vn.nguyen.request.UserPageRequest;
import vn.nguyen.request.UserRequest;
import vn.nguyen.response.BaseResponse;
import vn.nguyen.service.AccountService;
import vn.nguyen.service.UserService;

import java.util.List;

/**
 * Created by quocnguyen on 22/12/2015.
 */

@RestController
public class HomeController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public BaseResponse createUser(@RequestBody UserRequest userRequest, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + userRequest.getName());

//        if (userService.isUserExist(userRequest)) {
////            throw new UserException();
//            System.out.println("A User with name " + userRequest.getName() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }

        userService.saveUser(userRequest);

//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(userRequest.getUserId()).toUri());
        return new BaseResponse();
    }
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable("id") String id, @RequestBody UserRequest userRequest) {
        System.out.println("Updating User " + id);

        User currentUser = userService.findById(id);

        if (currentUser==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
//
//        currentUser.setName(userRequest.getName());
//        currentUser.setAge(userRequest.getAge());
//        currentUser.setSalary(userRequest.getSalary());

        User update = userService.updateUser(userRequest);
        return new ResponseEntity<User>(update, HttpStatus.OK);
    }
    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public BaseResponse<List<User>> findAllUser(){
        List<User> users = userService.findAllUsers();
        return new BaseResponse<List<User>>(users);
    }

    @RequestMapping(value = "/userpage/", method = RequestMethod.POST)
    public BaseResponse<Page<User>> findAllUserPaging(@RequestBody UserPageRequest userPageRequest){
        Page<User> users = userService.listAllUser(new PageRequest(userPageRequest.getPageOffset(),userPageRequest.getPageSize(), Sort.Direction.DESC,"userid"));
        return new BaseResponse<Page<User>>(users);
    }


}
