package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import web.dao.UserDAO;
import web.model.User;

@Controller
public class UserController {

    @GetMapping(value = "/")
    public String printUsers(Model model, UserDAO userDAO) {

        model.addAttribute("users", userDAO.getAllUsers());
        return "index";
    }

    @GetMapping(value = "/{id}")
    public String changeUser(Model model, @PathVariable int id, UserDAO userDAO) {
        model.addAttribute("user", userDAO.getUserById(id));
        return "change";
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {

    }
}
