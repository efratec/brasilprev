package com.brasilprev.api.service.authenticate;

import com.brasilprev.api.model.User;
import com.brasilprev.api.model.enums.UserRoles;

import java.util.List;

public interface GeneratorToken {

    String generate(User user, List<UserRoles> userRoles);

}
