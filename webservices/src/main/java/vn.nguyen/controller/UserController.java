package vn.nguyen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by quocnguyen on 31/12/2015.
 */
@Controller
@RequestMapping("/")
public class UserController {
    @RequestMapping(method = RequestMethod.GET)
    public String getUsers(){
        return "users";
    }
}

