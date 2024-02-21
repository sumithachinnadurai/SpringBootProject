package com.example.PROJECT1.service;

import com.example.PROJECT1.model.SignUp;
import com.example.PROJECT1.repository.SignUpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SignUpService {
    @Autowired
    SignUpRepo signuprepo;

    public SignUp createsignup(SignUp s) {
        return signuprepo.save(s);
    }

    public SignUp findsignup(int id) {
        return signuprepo.findById(id).orElse(null);
    }

    public List<SignUp> getsignup() {
        return signuprepo.findAll();
    }

    public SignUp updatesignup(int id, SignUp s) {
        SignUp s1 = signuprepo.findById(id).orElse(null);
        if (s1 != null) {
            s1.setFirstName(s.getFirstName());
            s1.setLastName(s.getLastName());
            signuprepo.save(s1);
            return s1;
        } else {
            return s;
        }
    }

    public void deletesignup(int id) {
        signuprepo.deleteById(id);
    }
}