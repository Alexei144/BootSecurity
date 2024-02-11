package ru.kata.spring.boot_security.demo.initDB;

import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.service.RoleServiceImpl;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class Init {
    private final UserServiceImpl userService;
    private final RoleServiceImpl roleService;
    public Init (UserServiceImpl userService, RoleServiceImpl roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }





    @PostConstruct
    public void Init() {

    Role roleAdmin = new Role(1L, "ROLE_ADMIN");
    Role roleUser = new Role(2L, "ROLE_USER");

    roleService.add(roleAdmin);
    roleService.add(roleUser);

    Set<Role> roleSet = new HashSet<>();
    roleSet.add(roleAdmin);
    roleSet.add(roleUser);

    Set<Role> roleSet1 = new HashSet<>();
    roleSet1.add(roleUser);


        User userAdmin = new User("admin", "100");
        userAdmin.setRoles(roleSet);

        User userUser = new User("user", "100");
        userUser.setRoles(roleSet1);
        userService.save(userAdmin);
        userService.save(userUser);

    }
}
