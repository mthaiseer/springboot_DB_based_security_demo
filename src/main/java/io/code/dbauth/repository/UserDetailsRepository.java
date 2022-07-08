package io.code.dbauth.repository;

import io.code.dbauth.entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<MyUser, Long> {

    MyUser findMyUserByUsername(String username);
}
