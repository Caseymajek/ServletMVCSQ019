package com.decagon.servletmvcsq019.serviceImpl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.decagon.servletmvcsq019.dto.LoginRequestDto;
import com.decagon.servletmvcsq019.dto.UserDto;
import com.decagon.servletmvcsq019.model.User;
//import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserServiceImpl {
    public static List<User> savedUsers = new ArrayList<>();
    public Function<UserDto, User> saveUserInformation = (userDto -> {
        User user = new User(userDto);
        user.setId(savedUsers.size() == 0 ? 1 : (long) savedUsers.size() + 1);
        savedUsers.add(user);
        return user;
    });
    public Function<LoginRequestDto, User> findUserByEmail = (loggedInUser) ->savedUsers
            .stream()
                .filter(user -> Objects.equals(user.getEmail(), loggedInUser.getEmail()))
                .collect(Collectors.toList()).get(0);

        public Function<LoginRequestDto, Boolean> verifyPassword = (user) -> BCrypt.verifyer()
                .verify(user.getPassword().toCharArray(),
                        user.getHashPassword()).verified;

}
