package com.music.wynk.repositories;

import com.music.wynk.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findByUserId(String userId);
    User findByUserName(String userName);

}
