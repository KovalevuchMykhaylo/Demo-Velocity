package org.springmodules.mailing.core.services;

import org.springmodules.mailing.core.entity.User;

import java.util.List;

/**
 * Created by andresmerida on 3/3/2016.
 */
public interface UserService {

    User saveUser(User user);

    List<User> findAll();
}
