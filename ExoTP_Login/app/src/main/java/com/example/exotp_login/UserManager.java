package com.example.exotp_login;

import java.util.ArrayList;

public class UserManager {
    public static UserManager instance;

    private ArrayList<String> usernames;
    private ArrayList<String> passwords;

    private UserManager(){
        usernames = new ArrayList<>();
        passwords = new ArrayList<>();
    }

    public static UserManager getInstance(){
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    public void addUser(String username, String password) {
        usernames.add(username);
        passwords.add(password);
    }

    public boolean checkUser(String username, String password) {
        int index = usernames.indexOf(username);

        return index != -1 && passwords.get(index).equals(password);

    }
}
