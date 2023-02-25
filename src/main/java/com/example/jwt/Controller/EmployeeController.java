package com.example.jwt.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin

public class EmployeeController {

    @GetMapping("/employee")

    public String employee() {
        return "Welcome Employee";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Welcome Admin";
    }

}
