package com.exception.test.bean;

import lombok.*;

import java.util.Set;

/**
 * @auther wangnanbei
 * @date 2020/11/24 15:06
 */

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    private String id;
    private String name;
    private String username;
    private String memo;
    private String password;
    private String role_id;

    private Set<Role> roles;


}
