package com.example.demo.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserService {

    private static List<User> users = new ArrayList<>();
    private static int usersCount = 3;

    static {
        users.add(new User(1,"Test1", new Date()));
        users.add(new User(2,"Test2", new Date()));
        users.add(new User(3,"Test3", new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        if(user.getId() == null){
            user.setId(usersCount++);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id){
        for (User user : users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

}