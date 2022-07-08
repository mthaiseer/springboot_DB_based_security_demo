package io.code.dbauth.config;

import io.code.dbauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
public class AuthConfig extends WebSecurityConfigurerAdapter {

    private static final String DEVELOPER_AUTHORITY = "developer";
    private static final String DEVOPS_AUTHORITY = "devops";


    @Autowired
    private UserService userService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {


        auth.userDetailsService(userService);


    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.httpBasic()
               .and()
               .authorizeHttpRequests()
               .antMatchers("/developer/**").hasAnyAuthority(DEVELOPER_AUTHORITY)
               .antMatchers("/devops/**").hasAnyAuthority(DEVOPS_AUTHORITY)
               .antMatchers(HttpMethod.POST, "/signup/**").permitAll()
               .antMatchers("/**").permitAll()
               .and()
               .formLogin();

        http.csrf().disable();
    }

    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}
