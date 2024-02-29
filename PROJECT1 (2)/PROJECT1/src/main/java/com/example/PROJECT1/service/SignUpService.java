// package com.example.PROJECT1.service;

// import com.example.PROJECT1.model.SignUp;
// import com.example.PROJECT1.repository.SignUpRepo;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import java.util.List;

// @Service
// public class SignUpService {
//     @Autowired
//     SignUpRepo signuprepo;

//     public SignUp createsignup(SignUp s) {
//         return signuprepo.save(s);
//     }

//     public SignUp findsignup(int id) {
//         return signuprepo.findById(id).orElse(null);
//     }

//     public List<SignUp> getsignup() {
//         return signuprepo.findAll();
//     }

//     public SignUp updatesignup(int id, SignUp s) {
//         SignUp s1 = signuprepo.findById(id).orElse(null);
//         if (s1 != null) {
//             s1.setFirstName(s.getFirstName());
//             s1.setLastName(s.getLastName());
//             signuprepo.save(s1);
//             return s1;
//         } else {
//             return s;
//         }
//     }

//     public void deletesignup(int id) {
//         signuprepo.deleteById(id);
//     }
// }

package com.example.PROJECT1.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;

import com.example.PROJECT1.model.SignUp;
import com.example.PROJECT1.repository.SignUpRepo;

@Service
public class SignUpService {
    @Autowired
    SignUpRepo repo;

    public SignUp create(SignUp j) {
        return repo.save(j);
        // return true;
    }

    public SignUp find(int id) {
        return repo.findById(id).orElse(null);
    }

    public List<SignUp> findA() {
        return repo.findAll();
    }

    public SignUp update(int id, SignUp j) {
        SignUp p1 = repo.findById(id).orElse(null);
        if (p1 != null) {
            p1.setName(j.getName());
            repo.save(p1);
            return p1;
        } else {
            return j;
        }
    }

    public void delete(int id) {
        repo.deleteById(id);

    }

    public Page<SignUp> findAllPaginatedAndSorted(int pageNo, int pageSize, String sortBy, String direction) {
        Sort sort = Sort.by(Sort.Direction.fromString(direction), sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return repo.findAll(pageable);
    }
}