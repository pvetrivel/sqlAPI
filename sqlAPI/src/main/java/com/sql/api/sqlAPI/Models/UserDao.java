package com.sql.api.sqlAPI.Models;


import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Long> {
    Iterable<User> findAll();

}

