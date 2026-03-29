package com.ecoquest.services;

import com.ecoquest.models.User;
import com.ecoquest.utils.ConsoleLooks;
import java.util.List;

// this is the authorization file for user login system
public class AuthService {
    private static final String FILE_NAME = "users.txt";
    public boolean register(String username, String password) {
        List<String> users = FileService.readFromFile(FILE_NAME);
        for (String line : users) {
            if (line.split(",")[0].equals(username)) {
                ConsoleLooks.printError("User already exists!");
                return false;
            }
        }
        User newUser = new User(username, password);
        FileService.saveToFile(FILE_NAME, newUser.toCSV(), true);
        return true;
    }
    public boolean login(String username, String password) {
        List<String> users = FileService.readFromFile(FILE_NAME);
        String hash = String.valueOf(password.hashCode());
        
        for (String line : users) {
            String[] parts = line.split(",");
            if (parts[0].equals(username) && parts[1].equals(hash)) {
                return true;
            }
        }
        return false;
    }
}