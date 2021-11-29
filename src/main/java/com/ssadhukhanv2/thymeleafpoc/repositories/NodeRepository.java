package com.ssadhukhanv2.thymeleafpoc.repositories;


import com.ssadhukhanv2.thymeleafpoc.model.Node;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NodeRepository extends CrudRepository<Node, Long> {
}
