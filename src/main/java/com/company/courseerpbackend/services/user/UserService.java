package com.company.courseerpbackend.services.user;

import com.company.courseerpbackend.models.mybatis.user.User;

public interface UserService {

    void insert(User user);

    User getByEmail(String email);

    boolean checkByEmail(String email);

}
