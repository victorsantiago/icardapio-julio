package br.com.icardapio.service;

import java.util.List;

import br.com.icardapio.entity.User;

public interface UserService {

    Integer addUser(User user);

    List<User> getAllUsers();

    User getUserByUsername(String username);

    User getUserById(int id);

    List<User> getAllAdmins();
}