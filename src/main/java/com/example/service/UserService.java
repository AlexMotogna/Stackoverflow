package com.example.service;

import com.example.dto.AuthDTO;
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

    public User createUser(User user) {
        try {
            iUserRepository.save(user);
            return user;
        } catch (Exception e) {
            return null;
        }
    }

    public List<User> getAllUsers() {
        return (List<User>) iUserRepository.findAll();
    }

    public User getUserById(Integer id) {
        return iUserRepository.findById(id).orElse(null);
    }

    public User login(AuthDTO auth) {
        User user = iUserRepository.findByUsername(auth.getUsername());

        try {
            if(auth.getPassword().equals(user.getPassword())) {
                return user;
            } else {
                return null;
            }
        } catch (NullPointerException e) {
            return null;
        }
    }

    public String updateUser(User user) {
        try {
            User updatedUser = this.getUserById(user.getId());

            updatedUser.setUsername(user.getUsername());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setPassword(user.getPassword());
            updatedUser.setScore(user.getScore());
            updatedUser.setBanned(user.getBanned());
            updatedUser.setAdmin(user.getAdmin());

            iUserRepository.save(updatedUser);

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
