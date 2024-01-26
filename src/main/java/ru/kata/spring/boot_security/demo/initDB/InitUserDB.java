package ru.kata.spring.boot_security.demo.initDB;


import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;

import javax.annotation.PostConstruct;
import java.util.Set;

@Component
public class InitUserDB {

    @PostConstruct
    public void init() {
        User admin = new User("admin", "admin");
        User user = new User("user", "user");


    }

}


//создаём пару юзеров с аннотацией @post-constract
