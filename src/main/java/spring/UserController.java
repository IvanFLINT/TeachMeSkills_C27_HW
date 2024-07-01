package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String showIndexPage() {
        return "index";
    }

    @GetMapping("/create")
    public String showCreateUserForm(Model model) {
        model.addAttribute("user", new User());
        return "createUser";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute("user") User user, Model model) {
        boolean isCreated = userService.createUser(user.getLogin(), user.getPassword());

        if (isCreated) {
            return "result";
        } else {
            return "operationError";
        }
    }

    @GetMapping("/change-login")
    public String showChangeLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "changeLoginUser";
    }

    @PostMapping("/change-login")
    public String changeUserLogin(@RequestParam("id") String id,
                                  @RequestParam("login") String newLogin,
                                  Model model) {
        boolean isUpdated = userService.changeUserLogin(Integer.parseInt(id), newLogin);

        if (isUpdated) {
            return "result";
        } else {
            return "operationError";
        }
    }

    @GetMapping("/delete")
    public String showDeleteUserForm(Model model) {
        model.addAttribute("user", new User());
        return "deleteUser";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") String id, Model model) {
        boolean isDeleted = userService.deleteUser(Integer.parseInt(id));

        if (isDeleted) {
            return "result";
        } else {
            return "operationError";
        }
    }

    @GetMapping("/get")
    public String getUserInfo(@RequestParam(name = "id", required = false) String id, Model model) {
        if (id == null || id.isEmpty()) {
            return "getUser";
        } else {
            try {
                int userId = Integer.parseInt(id);
                User user = userService.getUserById(userId);

                if (user != null) {
                    model.addAttribute("user", user);
                    return "resultDB";
                } else {
                    return "operationError";
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return "operationError";
            }
        }
    }
}
