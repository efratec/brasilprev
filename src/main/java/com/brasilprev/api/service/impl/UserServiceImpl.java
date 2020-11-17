package com.brasilprev.api.service.impl;

import com.brasilprev.api.dto.LoginDTO;
import com.brasilprev.api.exception.user.InvalidPasswordException;
import com.brasilprev.api.exception.user.UserDoesNotExistException;
import com.brasilprev.api.model.User;
import com.brasilprev.api.repository.UserRepository;
import com.brasilprev.api.security.service.JwtService;
import com.brasilprev.api.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @Override
    public User findUserByEmailAndPasswordForLogin(String email, String password) throws UserDoesNotExistException {
        return userRepository.findByEmailAndPassword(email, password).orElseThrow(UserDoesNotExistException::new);
    }

    @Override
    public String authenticateUser(LoginDTO login) throws UserDoesNotExistException, InvalidPasswordException {
        log.info("User authentication attempt, {}", login.getEmail());
        User user = userRepository.findByEmail(login.getEmail()).orElseThrow(UserDoesNotExistException::new);

        if (!login.getPassword().equals(user.getPassword())) {
            throw new InvalidPasswordException();
        }

        return jwtService.getToken(user);
    }

}
