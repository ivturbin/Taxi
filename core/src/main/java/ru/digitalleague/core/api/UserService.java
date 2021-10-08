package ru.digitalleague.core.api;

import org.springframework.stereotype.Service;
import ru.digitalleague.core.model.User;

@Service
public interface UserService {
    User registration(User user);

    User login(String login);
}
