package com.company.courseerpbackend.models.mybatis.user;

import com.company.courseerpbackend.models.enums.user.UserStatus;
import com.company.courseerpbackend.models.mybatis.base.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends BaseEntity {

    String name;
    String surname;
    UserStatus status;
    Long roleId;
    String email;
    String phoneNumber;
    String password;

}
