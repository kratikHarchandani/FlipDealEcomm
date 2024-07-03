package com.flipdeal_ecommerce.flipdeal_ecomm.repositories;

import com.flipdeal_ecommerce.flipdeal_ecomm.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailsRepository extends JpaRepository<User,Integer>{

    Optional<User> findByEmail(String email);

    @Override
    User save(User user);
}
