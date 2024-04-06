package ru.gb.example3_sem3_hometask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.example3_sem3_hometask.domain.User;

@Service
public class RegistrationService {

    private final DataProcessingService dataProcessingService;

    private final UserService userService;

    private final NotificationService notificationService;

    public RegistrationService(DataProcessingService dataProcessingService, UserService userService, NotificationService notificationService) {
        this.dataProcessingService = dataProcessingService;
        this.userService = userService;
        this.notificationService = notificationService;
    }

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    public UserService getUserService() {
        return userService;
    }

    public NotificationService getNotificationService() {
        return notificationService;
    }

    public void userRegistration(User user) {
        User createdUser = userService.createUser(user.getName(), user.getAge(), user.getEmail());
        notificationService.notifyUser(createdUser);
        dataProcessingService.addUser(createdUser);
    }
}
