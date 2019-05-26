package br.com.icardapio.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.icardapio.entity.User;
import br.com.icardapio.repositories.UserRepository;
import br.com.icardapio.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public Integer addUser(User user) {
        return userRepository.add(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    public User getUserById(int id) {
        return userRepository.findOne(id);
    }

    public List<User> getAllAdmins() {
        return userRepository.getAllAdmins();
    }

}
