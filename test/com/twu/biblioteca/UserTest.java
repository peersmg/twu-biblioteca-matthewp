package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserTest {

    @Test
    public void canValidateUser()
    {
        User testUser = new User("111-1111", "password");

        boolean loginSuccess = testUser.validate("password");
        boolean loginFails = testUser.validate("wrong-password");

        assertThat(loginSuccess, is(true));
        assertThat(loginFails, is(false));
    }
}
