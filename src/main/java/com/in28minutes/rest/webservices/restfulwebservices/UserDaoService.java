package com.in28minutes.rest.webservices.restfulwebservices;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();
    private static int userCount = 0;

    static {
        users.add(new User(++userCount, "Caleb", LocalDate.now().minusYears(27)));
        users.add(new User(++userCount, "Luna", LocalDate.now().minusYears(3)));
        users.add(new User(++userCount, "Amy", LocalDate.now().minusYears(50)));
        users.add(new User(++userCount, "Gary", LocalDate.now().minusYears(55)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public User save(User user) {
        user.setId(++userCount);
        users.add(user);
        return user;
    }
}
