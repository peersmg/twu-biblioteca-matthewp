package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserTest {
    User testUser;
    @Before
    public void init()
    {
        testUser = new User("111-1111", "password", "Matt", "email@email.com", "07965330222");
    }
    @Test
    public void canValidateUser()
    {
        boolean loginSuccess = testUser.validate("password");
        boolean loginFails = testUser.validate("wrong-password");

        assertThat(loginSuccess, is(true));
        assertThat(loginFails, is(false));
    }

    @Test
    public void canGetUserName()
    {
        assertThat("Matt", containsString(testUser.getName()));
    }

    @Test
    public void canGetUserEmail()
    {
        assertThat("email@email.com", containsString(testUser.getEmail()));
    }

    @Test
    public void canGetUserPhoneNumber()
    {
        assertThat("07965330222", containsString(testUser.getPhoneNumber));
    }
}
