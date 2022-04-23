package com.example.controller;

import com.example.dto.AuthDTO;
import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    @ResponseBody
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get")
    @ResponseBody
    public User getUserById(@RequestParam(name = "id") Integer id) {
        return userService.getUserById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    @ResponseBody
    public User login(@RequestBody AuthDTO auth) {
        return userService.login(auth);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    @ResponseBody
    public String deleteUser(@RequestParam(name = "id") Integer id) {
        return userService.deleteUser(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    @ResponseBody
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    @ResponseBody
    public String updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

}
