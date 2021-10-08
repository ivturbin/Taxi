package ru.digitalleague.core.api;

import ru.digitalleague.core.model.User;

public interface UserService {
    User registration(User user);

    User login(String login);
}
