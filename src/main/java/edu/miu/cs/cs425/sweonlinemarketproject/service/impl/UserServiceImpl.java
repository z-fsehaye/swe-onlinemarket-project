package edu.miu.cs.cs425.sweonlinemarketproject.service.impl;

import edu.miu.cs.cs425.sweonlinemarketproject.model.Address;
import edu.miu.cs.cs425.sweonlinemarketproject.model.User;
import edu.miu.cs.cs425.sweonlinemarketproject.repository.UserRepository;
import edu.miu.cs.cs425.sweonlinemarketproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(Long id) { return userRepository.getById(id);}

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(User user, Long id) {
        User user1=userRepository.findById(id).orElse(null);
        if(!user1.equals(null)) {
            user1.setId(user.getId());
            user1.setFirstName(user.getFirstName());
            user1.setLastName(user.getLastName());
            user1.setUserName(user.getUserName());
            user1.setEmail(user.getEmail());
            user1.setPassword(user.getPassword());
            user1.setRole(user.getRole());
            user1.setApprovedSeller(user.isApprovedSeller());
            user1.setCreateDate(user.getCreateDate());
            user1.setModifiedDate(user.getModifiedDate());
            user1.setAddress(user.getAddress());
            return userRepository.save(user1);
        } else {
            return null;
        }
    }
}
