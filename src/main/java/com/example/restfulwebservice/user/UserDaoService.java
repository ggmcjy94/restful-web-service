package com.example.restfulwebservice.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


@Service
public class UserDaoService {

    private static List<User> users = new ArrayList<User>();
    private static int userCount = 3;

    static {
        users.add(new User(1, "hyunseok", new Date(),"pass1","70100101-111111"));
        users.add(new User(2, "Alice", new Date(),"pass2","8018018-11111111"));
        users.add(new User(3, "Elena", new Date(),"pass3","901919010-11111111"));

    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++userCount);
            user.setJoinDate(new Date());
        }
        users.add(user);
        return user;
    }


    public User findOne(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User deleteById(int id) {

        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }

}
