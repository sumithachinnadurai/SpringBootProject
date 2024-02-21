 package com.example.PROJECT1.controller;

import com.example.PROJECT1.model.SignUp;
import com.example.PROJECT1.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class SignUpController {
    @Autowired
    SignUpService signupservice;

    @PostMapping("/insertdata")
    public SignUp insert(@RequestBody SignUp u) {
        return signupservice.createsignup(u);
    }

    @GetMapping("/{id}")
    public SignUp get(@PathVariable int id) {
        return signupservice.findsignup(id);
    }

    @GetMapping("/getdata")
    public List<SignUp> get1() {
        return signupservice.getsignup();
    }

    @PutMapping("updatedata/{id}")
    public SignUp update(@PathVariable int id, @RequestBody SignUp su) {
        return signupservice.updatesignup(id, su);
    }

    @DeleteMapping("/deletedata{id}")
    public void delete(@PathVariable int id) {
        signupservice.deletesignup(id);
    }
}