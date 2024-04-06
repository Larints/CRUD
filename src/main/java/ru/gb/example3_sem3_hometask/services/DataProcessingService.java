package ru.gb.example3_sem3_hometask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.example3_sem3_hometask.domain.User;
import ru.gb.example3_sem3_hometask.repository.UserRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {


    private final UserRepository repository;

    public DataProcessingService(UserRepository repository) {
        this.repository = repository;
    }

    public UserRepository getRepository() {
        return repository;
    }

    public void addUserToList(User user) {
        repository.getUsers().add(user);
    }

    public List<User> sortUsersByAge() {
        return repository.getUsers().stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList());
    }

    public List<User> filterUsersByAge(int age) {
        return repository.getUsers().stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    public double calculateAverageAge() {
        return repository.getUsers().stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }

    public void addUser(User user) {
        this.repository.getUsers().add(user);
    }

}
