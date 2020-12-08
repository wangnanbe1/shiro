package com.exception.test.mapper;

import com.exception.test.bean.Permissions;
import com.exception.test.bean.Role;
import com.exception.test.bean.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.cursor.Cursor;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @auther wangnanbei
 * @date 2020/11/24 15:05
 */

@Component
public interface UserMapper {
    @Select("select * from users limit #{limit}")
    Cursor<User> findAll(@Param("limit") int limit);

    @Select("select id,name,USERNAME,PASSWORD,role_id from users where name =   #{name}")
    User findUserByName(@Param("name") String name);


    @Select("select role_id,role_name,permission_id from basic_role where role_id = #{role_id}")
    Set<Role> findPermissionId(@Param("role_id") String role_id);

    @Select("select permission_id,permission_name from basic_permission where permission_id = #{permission_id} ")
    Set<Permissions> findPermission(@Param("permission_id") String permission_id);
}
