// package com.example.PROJECT1.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// import com.example.PROJECT1.model.SignUp;

// @Repository
// public interface SignUpRepo extends JpaRepository<SignUp, Integer> {

// }

package com.example.PROJECT1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.PROJECT1.model.SignUp;

@Repository
public interface SignUpRepo extends JpaRepository<SignUp, Integer> {

}