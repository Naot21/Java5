package fpl.asm_java5.Controller;

import fpl.asm_java5.Beans.LoginBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    @GetMapping("/login")
    public String showLoginPage() {
        return "/view/login";
    }
    @PostMapping("/login")
    public String handleLogin(
            LoginBean loginBean,
            Model model) {
        model.addAttribute("username", loginBean.getUsername());
        model.addAttribute("password", loginBean.getPassword());
        boolean hasError = false;

        if (loginBean.getUsername().isBlank()) {
            model.addAttribute("errorUsername", "Username is required");
            hasError = true;
        }
        if (loginBean.getPassword().length() < 6 || loginBean.getPassword().isBlank()) {
            model.addAttribute("errorPassword", "Password must be at least 6 characters");
            hasError = true;
        }
        if (hasError) {
            return "/view/login";
        }
        return "redirect:/home";
    }
    @GetMapping("/info")
    public String info() {
        return "/view/info";
    }
    @GetMapping("/detail")
    public String detail() {
        return "/view/detail";
    }
    @GetMapping("/changepass")
    public String changepass() {
        return "/view/changepass";
    }
    @GetMapping("/cart")
    public String cart() {
        return "/view/cart";
    }
    @GetMapping("/payment")
    public String pay() {
        return "/view/payment";
    }

}