package com.example.sweater.service;

import com.example.sweater.MailSender;
import com.example.sweater.UserService;
import com.example.sweater.domain.Role;
import com.example.sweater.domain.User;
import com.example.sweater.repos.UserRepo;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @MockBean
    private UserRepo userRepo;

    @MockBean
    private MailSender mailSender;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @Test
    public void addUser() {
        User user = new User();
        user.setEmail("somemail@test.com");

        boolean isUserCreated = userService.addUser(user);

        Assert.assertTrue(isUserCreated);
        Assert.assertNotNull(user.getActivationCode());
        Assert.assertTrue(CoreMatchers.is(user.getRoles()).matches(Collections.singleton(Role.USER)));

        Mockito.verify(userRepo, Mockito.times(1)).save(user);

        Mockito.verify(mailSender, Mockito.times(1))
                .send(
                        ArgumentMatchers.eq(user.getEmail()),
                        ArgumentMatchers.eq("Activation code"),
                        ArgumentMatchers.contains("Welcome to Sweater"));
                        //ArgumentMatchers.anyString());
    }

    @Test
    public void addUserFailTest() {
        User user = new User();
        user.setUsername("John");

        Mockito.doReturn(new User())
                .when(userRepo)
                .findByUsername("John");

        boolean isUserCreated = userService.addUser(user);
        Assert.assertFalse(isUserCreated);

        Mockito.verify(userRepo, Mockito.times(0)).save(ArgumentMatchers.any(User.class));
        Mockito.verify(mailSender, Mockito.times(0))
                .send(
                        ArgumentMatchers.anyString(),
                        ArgumentMatchers.anyString(),
                        ArgumentMatchers.anyString());
    }

    @Test
    public void loadUserByUsername() {
    }

    @Test
    public void activateUser() {
        User user = new User();
        user.setActivationCode("done");

        Mockito.doReturn(user)
                .when(userRepo)
                .findByActivationCode("activate");

        boolean isUserActivated = userService.activateUser("activate");

        Assert.assertTrue(isUserActivated);
        Assert.assertNull(user.getActivationCode());

        Mockito.verify(userRepo, Mockito.times(0)).save(user);
    }

    @Test
    public void activateUserFail() {
        boolean isUserActivated = userService.activateUser("activate me");

        Assert.assertFalse(isUserActivated);

        Mockito.verify(userRepo, Mockito.times(0)).save(ArgumentMatchers.any(User.class));
    }
}