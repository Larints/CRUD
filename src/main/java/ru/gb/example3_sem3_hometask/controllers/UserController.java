package ru.gb.example3_sem3_hometask.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.example3_sem3_hometask.services.RegistrationService;
import ru.gb.example3_sem3_hometask.domain.User;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    private final RegistrationService service;

    public UserController(RegistrationService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> userList() {
        return service.getDataProcessingService().getRepository().getUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user) {
        service.userRegistration(user);
        return user.getName() + " successfully registered";
    }

}
