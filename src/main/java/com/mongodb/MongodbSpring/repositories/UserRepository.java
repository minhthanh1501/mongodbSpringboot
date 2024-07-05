package com.mongodb.MongodbSpring.repositories;

import com.mongodb.MongodbSpring.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    boolean existsByEmail(String username);
    Optional<User> findByEmail(String email);

    @Query("{ 'email' : {$regex: ?0, $options: 'i' } }")
    List<User> SearchByEmailRegex(String character);
}
