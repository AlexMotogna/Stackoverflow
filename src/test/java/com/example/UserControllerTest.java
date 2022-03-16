package com.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import com.example.controller.UserController;
import com.example.model.User;
import com.example.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @InjectMocks
    UserController userController;

    @Mock
    private UserService userService;

    private List<User> userList;

    public UserControllerTest() {
    }

    @BeforeEach
    void setUp() {
        this.userList = new ArrayList<>();
        this.userList.add(new User(1, "Alex Motogna", "email@mail.com", "1234", 0, false, false));
        this.userList.add(new User(2, "Person1", "person1@mail.com", "12345", 0, false, false));
        this.userList.add(new User(3, "Person2", "person2@mail.com", "123456", 0, false, true));
    }

    @Test
    void findAllTest() throws Exception {

        when(userService.getAllUsers()).thenReturn(userList);

        List<User> result = userController.getAllUsers();

        assertThat(result.size()).isEqualTo(3);
        assertThat(result.get(0).getUsername()).isEqualTo("Alex Motogna");
        assertThat(result.get(2).getPassword()).isEqualTo("123456");
    }


}
