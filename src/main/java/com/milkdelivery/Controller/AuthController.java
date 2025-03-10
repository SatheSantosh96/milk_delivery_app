package com.milkdelivery.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/signup")
    public String showSignupPage() {
        return "signup";  // This should match signup.html in templates
    }
}

