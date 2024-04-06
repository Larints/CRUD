package ru.gb.example3_sem3_hometask.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.example3_sem3_hometask.domain.User;
import ru.gb.example3_sem3_hometask.services.DataProcessingService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {


    private final DataProcessingService service;

    public TaskController(DataProcessingService service) {
        this.service = service;
    }

    @GetMapping
    public List<String> getAllTasks() {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    @GetMapping("/sort")//localhost:8080/tasks/sort
    public List<User> sortUsersByAge() {
        return service.sortUsersByAge();
    }

    @GetMapping("/filter/{age}") //localhost:8080/tasks/filter
    public List<User> filterByAge(@PathVariable int age) {
        return service.filterUsersByAge(age);
    }

    @GetMapping("/calc")
    public double calculateByAge() {
        return service.calculateAverageAge();
    }
}
