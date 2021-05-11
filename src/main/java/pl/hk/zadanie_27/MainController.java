package pl.hk.zadanie_27;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MainController {
    private final UserRepository userRepository;

    public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<User> all = userRepository.findAll();
        model.addAttribute("users", all);
        return "home";
    }

    @GetMapping("/add")
    public String addUser(Model model) {
        model.addAttribute("userToAdd", new User());
        return "addUser";
    }

    @PostMapping("/add")
    public String addUser(User user) {
        userRepository.save(user);
        return "redirect:/";
    }
}
