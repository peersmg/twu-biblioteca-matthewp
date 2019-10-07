package com.twu.biblioteca;

import java.util.HashMap;

public class UserRegister {
    private HashMap<String, User> registeredUsers;
    public UserRegister() {
        registeredUsers = new HashMap<>();
    }

    public void addUser(User newUser)
    {
        if(!userExists(newUser.getId()))
        {
            registeredUsers.put(newUser.getId(), newUser);
        }
    }

    public boolean userExists(String userId)
    {
        return registeredUsers.containsKey(userId);
    }

    public User getUser(String userId, String userPassword)
    {
        if(userExists(userId))
        {
            User user = registeredUsers.get(userId);
            if(user.validate(userPassword))
            {
                return user;
            }
        }
        return null;
    }


}
