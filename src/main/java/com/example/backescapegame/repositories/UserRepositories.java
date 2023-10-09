package com.example.backescapegame.repositories;



import com.example.backescapegame.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositories extends CrudRepository<User, Integer> {

}