package com.brasilprev.api.web.rest;

import com.brasilprev.api.dto.LoginDTO;
import com.brasilprev.api.dto.TokenDTO;
import com.brasilprev.api.exception.user.InvalidPasswordException;
import com.brasilprev.api.exception.user.UserDoesNotExistException;
import com.brasilprev.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/login")
//@Api(value = "Brasilprevi services")
@CrossOrigin(origins = "*")
public class LoginResource {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/authentication")
    public ResponseEntity<TokenDTO> authenticate(@RequestBody LoginDTO loginDTO) throws UserDoesNotExistException, InvalidPasswordException {
        return ok(new TokenDTO(userService.authenticateUser(loginDTO)));
    }

}
