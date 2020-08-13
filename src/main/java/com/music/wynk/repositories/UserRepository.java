package com.music.wynk.repositories;

import com.music.wynk.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

    User findByUserName(String userName);

}
