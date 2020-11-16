package com.brasilprev.api.service.impl;

import com.brasilprev.api.exception.user.InvalidPasswordException;
import com.brasilprev.api.model.User;
import com.brasilprev.api.repository.UserRepository;
import com.brasilprev.api.service.UserSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityServiceImpl implements UserSecurityService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void authenticate(User user) throws Exception {
        UserDetails userDetails = loadUserByUsername(user.getEmail());
		if (!user.getPassword().equals(userDetails.getPassword())) {
			throw new InvalidPasswordException();
		}
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return getUserDetailsByUser(user);
    }

    private UserDetails getUserDetailsByUser(User user) {
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRole().name())
                .build();
    }

}
