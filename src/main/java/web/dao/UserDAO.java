package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserDAO {
    private List<User> users;
    private static int count;

    public UserDAO() {
        this.users = new ArrayList<>();
        this.addUser(new User(0, "John", 20, 1.6));
        this.addUser(new User(0, "Mary", 60, 2.5));
        this.addUser(new User(0, "Anna", 90, -0.4));
        this.addUser(new User(0, "Yog-Sothoth", 2000000000, 1300));
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User getUserById(int id) {
        return users.stream().filter(user -> user.getId() == id)
                .findFirst().orElse(null);
    }

    public void addUser(User user) {
        user.setId(++count);
        users.add(user);
    }

    public void changeUser(User newUser, int id) {
        User oldUser = getUserById(id);
        oldUser.setName(newUser.getName());
        oldUser.setAge(newUser.getAge());
        oldUser.setSkill(newUser.getSkill());
    }

    public void deleteUserById(int id) {
        users.removeIf(user -> user.getId() == id);
    }
}
