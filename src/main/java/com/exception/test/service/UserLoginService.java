package com.exception.test.service;

import com.exception.test.bean.Permissions;
import com.exception.test.bean.Role;
import com.exception.test.bean.User;
import com.exception.test.mapper.UserMapper;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @auther wangnanbei♥liupei
 * @date 2020/11/26 18:03
 */

@Service
public class UserLoginService {

    @Autowired
    private UserMapper userMapper;

    public User getUser(String userName) {
        User user = userMapper.findUserByName(userName);
        Set<Role> roles = userMapper.findPermissionId(user.getRole_id());
        roles.forEach(role -> {
            Set<Permissions> permission = userMapper.findPermission(role.getPermission_id());
            role.setPermissions(permission);
        });
        user.setRoles(roles);
        return user;
    }


}
