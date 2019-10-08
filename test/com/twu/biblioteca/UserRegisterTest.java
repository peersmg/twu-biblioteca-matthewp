package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserRegisterTest {
    @Test
    public void canRegisterUser()
    {
        UserRegister userRegister = new UserRegister();

        User newUser = new User("111-1111", "password", "Matt", "matt@email.com", "07834233922");
        userRegister.addUser(newUser);

        boolean userExists = userRegister.userExists("111-1111");

        assertThat(userExists, is(true));
    }

    @Test
    public  void canGetUser()
    {
        UserRegister userRegister = new UserRegister();

        User newUser = new User("111-1111", "password", "Matt", "matt@email.com", "07834233922");
        userRegister.addUser(newUser);

        User loggedUser = userRegister.getUser("111-1111", "password");

        assertThat(newUser, is(loggedUser));
    }

}
