package com.company.courseerpbackend.services.user;

import com.company.courseerpbackend.models.mybatis.user.User;
import com.company.courseerpbackend.models.security.LoggedInUserDetails;
import com.company.courseerpbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public void insert(User user) {
        userRepository.insert(user);
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("User not found")
        );
    }

    @Override
    public boolean checkByEmail(String email) {
        return userRepository.
                findByEmail(email).isPresent();
    }


}
