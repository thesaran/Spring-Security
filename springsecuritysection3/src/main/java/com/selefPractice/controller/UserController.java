package com.selefPractice.controller;


import com.selefPractice.model.Customer;
import com.selefPractice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {


    private final CustomerRepository customerRepository;

    private final PasswordEncoder passwordEncoder;

    @RequestMapping(value="/createCustomer", method= RequestMethod.POST, produces ="application/json")
public ResponseEntity<String> registerUSer (@RequestBody Customer request ){

 try {
        String hashPassword = passwordEncoder.encode(request.getPassword());
        request.setPassword(hashPassword);
        Customer customer =  customerRepository.save(request);
        if (customer.getCustomerId()>0){
            return ResponseEntity.status(HttpStatus.CREATED).body("Customer has successfully created!!");
        }else {
            return     ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unable to create customer!");
        }

 } catch ( Exception exception){
     return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An exception has occured");
 }
}
}
