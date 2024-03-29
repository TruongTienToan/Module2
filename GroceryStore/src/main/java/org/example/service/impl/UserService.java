package org.example.service.impl;

import org.example.model.Role;
import org.example.model.User;
import org.example.service.IUserService;
import org.example.utils.CSVUtils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService {
    public final static String PATH = "./data/users.csv";
    private static UserService instance;

    private UserService() {

    }

    public static UserService getInstance() {
        if (instance == null)
            instance = new UserService();
        return instance;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        List<String> records = CSVUtils.readToFile(PATH);
        for (String record : records) {
            users.add(User.parseUser(record));
        }
        return users;
    }

    @Override
    public User adminLogin(String username, String password) {
        List<User> users = findAll();
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)
                    && user.getRole().equals(Role.ADMIN)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void add(User newUser) {
        newUser.setId(System.currentTimeMillis() / 1000);
        newUser.setCreatedAt(Instant.now());
        List<User> users = findAll();
        users.add(newUser);
        CSVUtils.writeToFile(PATH, users);
    }

    @Override
    public void update(User newUser) {
        List<User> users = findAll();
        for (User user : users) {
            if (user.getId().equals(newUser.getId())) {
                String fullName = newUser.getFullName();
                if (fullName != null && !fullName.isEmpty())
                    user.setFullName(fullName);
                String phone = newUser.getMobile();
                if (phone != null && !phone.isEmpty())
                    user.setMobile(newUser.getMobile());
                String address = newUser.getAddress();
                if (address != null && !address.isEmpty())
                    user.setAddress(newUser.getAddress());
                String email = newUser.getEmail();
                if (email != null && !email.isEmpty())
                    user.setEmail(newUser.getEmail());
                user.setUpdatedAt(Instant.now());
                CSVUtils.writeToFile(PATH, users);
                break;
            }
        }
    }

    @Override
    public void deleteUser(int idUser) {
        List<User> users = findAll();
        for (User user : users) {
            if (user.getId() == idUser) {
                if (user.getRole().equals(Role.USER)) {
                    System.out.println(user);
                    users.remove(user);
                    CSVUtils.writeToFile(PATH, users);
                }
            }
        }
    }

    @Override
    public boolean existById(int id) {
        return findById(id) != null;
    }

    @Override
    public boolean existsByEmail(String email) {
        List<User> users = findAll();
        for (User user : users) {
            if (user.getEmail().equals(email))
                return true;
        }
        return false;
    }

    @Override
    public boolean existsByPhone(String phone) {
        List<User> users = findAll();
        for (User user : users) {
            if (user.getMobile().equals(phone))
                return true;
        }
        return false;
    }

    @Override
    public boolean existsByUserName(String userName) {
        List<User> users = findAll();
        for (User user : users) {
            if (user.getUsername().equals(userName))
                return true;
        }
        return false;
    }

    @Override
    public User findById(int id) {
        List<User> users = findAll();
        for (User user : users) {
            if (user.getId() == id)
                return user;
        }
        return null;
    }
}
