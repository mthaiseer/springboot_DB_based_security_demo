package io.code.dbauth.service;

import io.code.dbauth.entity.MyUser;
import io.code.dbauth.repository.UserDetailsRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDetailsRepository.findMyUserByUsername(username);
    }

    public MyUser createUser(MyUser myUser){
        return userDetailsRepository.save(myUser);
    }


}
