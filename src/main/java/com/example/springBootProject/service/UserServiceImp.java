package com.example.springBootProject.service;

import com.example.springBootProject.exception.UserNotFoundException;
import com.example.springBootProject.models.User;
import com.example.springBootProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public void registerUser(User user) {
        userRepository.save(user);

    }
    @Override
    public User retrieveById(Integer id) throws UserNotFoundException {

      Optional<User> exist= userRepository.findById(id);
        if(exist.isEmpty()){
            throw new UserNotFoundException("User not found");

        }
        return exist.get();
    }

    @Override
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void updateUser(User user, Integer id) throws UserNotFoundException{
        Optional<User> exist=userRepository.findById(id);
        if(exist.isEmpty()){
            throw new UserNotFoundException("User not found");

        }
        if(!user.getFirstName().equals(exist.get().getFirstName())){
            exist.get().setFirstName(user.getFirstName());
        }
        if(!user.getLastName().equals(exist.get().getLastName())){
            exist.get().setLastName(user.getLastName());
        }
        if(!user.getPinCode().equals(exist.get().getPinCode())){
            exist.get().setPinCode(user.getPinCode());
        }
        userRepository.save(exist.get());

    }

    @Override
    public void deleteUser(Integer id) throws UserNotFoundException {
        Optional<User> exist=userRepository.findById(id);
        if(exist.isEmpty()){
            throw new UserNotFoundException("User not found");

        }
        userRepository.deleteById(id);

    }


}
