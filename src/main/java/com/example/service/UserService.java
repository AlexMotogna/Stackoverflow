package com.example.service;

import com.example.model.User;
import com.example.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    IUserRepository iUserRepository;

    public String createUser(User user) {
        try {
            iUserRepository.save(user);
            return "Creation success.";
        } catch (Exception e) {
            return "Creation failed.";
        }
    }

    public List<User> getAllUsers() {
        return (List<User>) iUserRepository.findAll();
    }

    public User getUserById(Integer id) {
        Optional<User> customer = iUserRepository.findById(id);
        return customer.orElse(null);
    }

    public String updateUser(User user) {
        try {
            User initialUser = this.getUserById(user.getId());

            initialUser.setUsername(user.getUsername());
            initialUser.setEmail(user.getEmail());
            initialUser.setPassword(user.getPassword());
            initialUser.setScore(user.getScore());
            initialUser.setBanned(user.getBanned());
            initialUser.setAdmin(user.getAdmin());

            iUserRepository.save(initialUser);

            return "Update success.";
        } catch (Exception e) {
            return "Update failed.";
        }
    }

    public String deleteUser(Integer id) {
        try {
            iUserRepository.delete(this.getUserById(id));
            return "Delete success.";
        } catch (Exception e) {
            return "Delete failed.";
        }
    }

}
