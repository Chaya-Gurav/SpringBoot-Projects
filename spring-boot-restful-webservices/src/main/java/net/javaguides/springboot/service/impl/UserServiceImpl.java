package net.javaguides.springboot.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRep;
    @Override
    public User createUser(User user) {
        return userRep.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        Optional<User> optionalUser = userRep.findById(userId);
        return optionalUser.get();
    }
}
