//  package com.example.PROJECT1.controller;

// import com.example.PROJECT1.model.SignUp;
// import com.example.PROJECT1.service.SignUpService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;
// import java.util.List;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.PathVariable;

// @RestController
// public class SignUpController {
//     @Autowired
//     SignUpService signupservice;

//     @PostMapping("/insertdata")
//     public SignUp insert(@RequestBody SignUp u) {
//         return signupservice.createsignup(u);
//     }

//     @GetMapping("/{id}")
//     public SignUp get(@PathVariable int id) {
//         return signupservice.findsignup(id);
//     }

//     @GetMapping("/getdata")
//     public List<SignUp> get1() {
//         return signupservice.getsignup();
//     }

//     @PutMapping("updatedata/{id}")
//     public SignUp update(@PathVariable int id, @RequestBody SignUp su) {
//         return signupservice.updatesignup(id, su);
//     }

//     @DeleteMapping("/deletedata{id}")
//     public void delete(@PathVariable int id) {
//         signupservice.deletesignup(id);
//     }
// }

package com.example.PROJECT1.controller;

import java.util.List;
import org.springframework.data.domain.Page;

// import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.PROJECT1.model.SignUp;
import com.example.PROJECT1.service.SignUpService;

@RestController
public class SignUpController {
    @Autowired
    SignUpService obj;

    @PostMapping("/create")
    public ResponseEntity<SignUp> insert(@RequestBody SignUp j) {
        return new ResponseEntity<>(obj.create(j), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public SignUp fin(@PathVariable int id) {
        return obj.find(id);
    }

    @GetMapping("/all")
    public List<SignUp> findA() {
        return obj.findA();
    }

    @GetMapping("/allPaginatedAndSorted")
    public Page<SignUp> findAllPaginatedAndSorted(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "ASC") String direction) {
        return obj.findAllPaginatedAndSorted(pageNo, pageSize, sortBy, direction);
    }

    @PutMapping("/update/{id}")
    public SignUp update(@PathVariable int id, @RequestBody SignUp u) {
        return obj.update(id, u);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        obj.delete(id);

    }

}