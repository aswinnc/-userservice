package com.tnsif.userservice;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    // Method to create a new user
    public User createUser(User user) {
        return userRepository.save(user);
    }
    
    // Method to retrieve all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    // Method to retrieve a user by id
    public java.util.Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
    
    // Method to update a user
    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id)
                                  .orElseThrow();
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        return userRepository.save(user);
    }
    
    // Method to delete a user
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
        		.orElseThrow();
        userRepository.delete(user);
    }
}
