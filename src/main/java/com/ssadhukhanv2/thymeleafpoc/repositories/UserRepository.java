package com.ssadhukhanv2.thymeleafpoc.repositories;

import com.ssadhukhanv2.thymeleafpoc.model.Node;
import com.ssadhukhanv2.thymeleafpoc.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByUserName(String userName);
}
