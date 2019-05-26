package br.com.icardapio.repositories;

import java.util.List;

import br.com.icardapio.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    User getUserByUsername(String username);

    List<User> getAllAdmins();
}
