package me.iantapply.scoutingPlatform.services;

import javax.servlet.http.HttpServletRequest;

import lombok.RequiredArgsConstructor;
import me.iantapply.scoutingPlatform.data.UserData;
import me.iantapply.scoutingPlatform.exceptions.CustomExceptions;
import me.iantapply.scoutingPlatform.security.JwtTokenProvider;
import me.iantapply.scoutingPlatform.utilities.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;

    public String signin(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return jwtTokenProvider.createToken(username, userRepository.findByUsername(username).getUserRoles());
        } catch (AuthenticationException e) {
            throw new CustomExceptions("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public String signup(UserData user) {
        if (!userRepository.existsByUsername(user.getUsername())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return jwtTokenProvider.createToken(user.getUsername(), user.getUserRoles());
        } else {
            throw new CustomExceptions("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public void delete(String username) {
        userRepository.deleteByUsername(username);
    }

    public UserData search(String username) {
        UserData user = userRepository.findByUsername(username);
        if (user == null) {
            throw new CustomExceptions("The user doesn't exist", HttpStatus.NOT_FOUND);
        }
        return user;
    }

    public UserData whoami(HttpServletRequest req) {
        return userRepository.findByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req)));
    }

    public String refresh(String username) {
        return jwtTokenProvider.createToken(username, userRepository.findByUsername(username).getUserRoles());
    }

}
