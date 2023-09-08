package com.SpringBootMicroservicesProject.UserService.Repository;

import com.SpringBootMicroservicesProject.UserService.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends MongoRepository<User,Object> {

}
