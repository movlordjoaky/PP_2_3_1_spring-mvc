package web.dao;

import web.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDAO {
    private List<User> users;

    public UserDAO() {
        this.users = new ArrayList<>();
        this.addUser(new User(1, "Миша", 20, 1.6));
        this.addUser(new User(2, "Катя", 60, 2.5));
        this.addUser(new User(3, "Коля", 90, -0.4));
        this.addUser(new User(4, "Ахмед", 16, 1.3));
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User getUserById(int id) {
        return users.stream().filter(user -> user.getId() == id)
                .findFirst().orElse(null);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void changeUser(User updatedUser) {
        Optional<User> userOptional = users.stream()
                .filter(user -> user.getId() == updatedUser.getId())
                .findFirst();

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            int index = users.indexOf(user);

            users.set(index, updatedUser);
        }
    }

    public void deleteUserById(int id) {
        users.removeIf(user -> user.getId() == id);
    }
}
