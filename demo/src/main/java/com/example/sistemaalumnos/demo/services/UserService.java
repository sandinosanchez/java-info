package com.example.sistemaalumnos.demo.services;

import com.example.sistemaalumnos.demo.model.User;
import com.example.sistemaalumnos.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        Optional<User> userFound = userRepository.findById(id);
        return userFound.orElse(null);
    }

    public User getUserByUserName(String userName){
        Optional<User> userFound = userRepository.findByUserName(userName);
        return userFound.orElse(null);
    }

    public void newUser(User user){
        Optional<User> userFound = userRepository.findByUserName(user.getUserName());
        if (!userFound.isPresent()) userRepository.save(user);
    }

    public void editUser(User user){
        User userToEdit = exists(user.getId());
        if (Objects.nonNull(userToEdit)) {
            userToEdit.setUserName(user.getUserName());
            userToEdit.setPassword(user.getPassword());
            userRepository.save(userToEdit);
        }
    }

    public void deleteUser(Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()){
            User deletedUser = optionalUser.get();
            userRepository.delete(deletedUser);
        }
    }

    public User exists(Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }
}
