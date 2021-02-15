package com.pfe.demo.repository;
import org.springframework.data.repository.CrudRepository;
import com.pfe.demo.model.User;


public interface UsersRepository extends CrudRepository<User,Integer> {

}
