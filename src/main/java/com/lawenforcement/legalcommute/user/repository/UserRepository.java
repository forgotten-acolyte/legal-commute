package com.lawenforcement.legalcommute.user.repository;

import com.lawenforcement.legalcommute.user.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

}
