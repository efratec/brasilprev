package com.brasilprev.api.service;

import com.brasilprev.api.dto.LoginDTO;
import com.brasilprev.api.exception.user.InvalidPasswordException;
import com.brasilprev.api.exception.user.UserDoesNotExistException;
import com.brasilprev.api.model.User;

public interface UserService {

  User findUserByEmailAndPasswordForLogin(String email, String password) throws UserDoesNotExistException;

  String authenticateUser(LoginDTO login) throws UserDoesNotExistException, InvalidPasswordException;

}
