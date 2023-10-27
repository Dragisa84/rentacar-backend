package com.rentacar.implementation;

import com.rentacar.model.User;
import com.rentacar.repo.UserRepository;
import com.rentacar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @created type UserServiceImpl
 * /p
 * @created by dstankovski
 * /p
 * @since 26/10/2023
 */
@Service
public class UserServiceImpl implements UserService {

    // Inject the repository
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        if (userRepository.existsById(id)) {
            user.setId(id);
            return userRepository.save(user);
        }
        return null; // Handle non-existing user
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
