package com.selefPractice.config;

import com.selefPractice.model.Customer;
import com.selefPractice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class EazybankUserDetailsService implements UserDetailsService {

   @Autowired
   private final CustomerRepository customerRepository;




    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

         Customer customer = customerRepository.findByUserName(userName).orElseThrow(()-> new UsernameNotFoundException
                ("User Details not found : "+ userName ));
         List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(customer.getCustomerType()));
         return new User(customer.getUserName(),customer.getPassword(),authorities);
    }
}
