package com.brasilprev.api.service;

import com.brasilprev.api.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserSecurityService extends UserDetailsService {

	void authenticate(User user) throws Exception;

}