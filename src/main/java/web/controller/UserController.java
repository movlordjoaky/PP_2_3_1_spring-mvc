package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDAO;
import web.model.User;

@Controller
public class UserController {
    private final UserDAO userDAO;

    @Autowired
    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    // вывод всех пользователей
    @GetMapping(value = "/")
    public String printUsers(Model model) {
        model.addAttribute("users", userDAO.getAllUsers());
        return "index";
    }

//    @GetMapping(value = "/{id}")
//    public String printUser(Model model, @PathVariable int id) {
//        model.addAttribute("user", userDAO.getUserById(id));
//        return "adspofuhapdso";
//    }

    // страница добавления пользователя
    @GetMapping(value = "/add")
    public String addUserForm(@ModelAttribute("user") User user) {
        return "add";
    }

    // команда на форме добавления пользователя
    @PostMapping()
    public String addUser(@ModelAttribute User user) {
        userDAO.addUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "/edit/{id}")
    public String changeUserForm(Model model, @PathVariable int id) {
        model.addAttribute("user", userDAO.getUserById(id));
        System.out.println(userDAO.getUserById(id));
        return "change";
    }

    @PatchMapping(value = "/{id}")
    public String changeUser(@ModelAttribute User user, @PathVariable int id) {
        userDAO.changeUser(user, id);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        userDAO.deleteUserById(id);
        return "redirect:/";
    }
}
