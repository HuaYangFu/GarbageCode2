package com.lexelpro.controller;

import com.lexelpro.entity.User;
import com.lexelpro.service.UserService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Lexel PRO
 * @version 1.0
 */
@Controller
public class UserController {

	public UserController() {
		System.out.println("UserController()");
	}

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public ModelAndView getAllUsers() {
        List<User> userList = userService.getAllUsers();
        return new ModelAndView("index", "userList", userList);
    }

    @RequestMapping("createUser")
    public ModelAndView createUser(@ModelAttribute User user) {
        ModelAndView MV = new ModelAndView("index");
        List<User> userList = userService.getAllUsers();
        MV.addObject("userList",userList);
        return MV;
    }

    @RequestMapping("update")
    public ModelAndView getAllUsers(@RequestParam User user) {
        userService.updateUser(user);
        List<User> userList = userService.getAllUsers();
        return new ModelAndView("index", "userList", userList);
    }

    @RequestMapping("editUser")
    public ModelAndView editUser(@RequestParam long id, @ModelAttribute User user) {
        ModelAndView MV = new ModelAndView("index");
        user = userService.getUser(id);
        List<User> userList = userService.getAllUsers();
        MV.addObject("userObject",user);
        MV.addObject("userList",userList);
        return MV;
    }
    
    @RequestMapping("deleteUser")
    public ModelAndView deleteUser(@RequestParam long id) {
        userService.deleteUser(id);
        List<User> userList = userService.getAllUsers();
        ModelAndView MV = new ModelAndView("index");
        MV.addObject("userList",userList);
        return MV;
    }

    @RequestMapping("saveUser")
    public ModelAndView saveUser(@ModelAttribute User user) {
        if(user.getId() == 0){ // if user id is 0 then creating the user other updating the user
            userService.createUser(user);
        } else {
            userService.updateUser(user);
        }
        ModelAndView MV = new ModelAndView("index");
        List<User> userList = userService.getAllUsers();
        MV.addObject("userList",userList);
        return MV;
    }

}