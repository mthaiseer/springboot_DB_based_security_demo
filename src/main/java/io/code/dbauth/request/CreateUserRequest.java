package io.code.dbauth.request;

import io.code.dbauth.entity.MyUser;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {

    private String username;
    private String password;
    private String authorities;


    public MyUser to(){

       return  MyUser.builder()
                .username(username)
                .password(new BCryptPasswordEncoder().encode(password))
                .authorities(authorities)
                .build();
    }
}
