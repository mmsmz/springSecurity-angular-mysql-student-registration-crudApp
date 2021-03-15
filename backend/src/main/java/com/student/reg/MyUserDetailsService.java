package com.student.reg;

import com.student.reg.Repository.UserServiceRepository;
import com.student.reg.entity.UserEntity;
import com.student.reg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserServiceRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = repo.findByUsername(username);
        if(userEntity==null){
            throw  new UsernameNotFoundException("User 404");
        }

        return new UserPrinciples(userEntity);
    }
}
