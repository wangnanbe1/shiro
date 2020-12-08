package com.exception.test.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

/**
 * @auther wangnanbei♥liupei
 * @date 2020/11/26 18:01
 */

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private String role_id;
    private String role_name;
    private String permission_id;
    private Set<Permissions> permissions;
}
