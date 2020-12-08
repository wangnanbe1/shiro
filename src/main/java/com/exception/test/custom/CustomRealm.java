package com.exception.test.custom;

import com.alibaba.druid.util.StringUtils;
import com.exception.test.bean.Permissions;
import com.exception.test.bean.Role;
import com.exception.test.bean.User;
import com.exception.test.service.UserLoginService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private UserLoginService userLoginService;


    /**
     * 权限配置
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        String name = (String) principals.getPrimaryPrincipal();
        User user = userLoginService.getUser(name);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        Set<Role> roles = user.getRoles();
        roles.forEach(role->{
            simpleAuthorizationInfo.addRole(role.getRole_name());
            for(Permissions permissions:role.getPermissions()){
                simpleAuthorizationInfo.addStringPermission(permissions.getPermission_name());
            }
        });

        return simpleAuthorizationInfo;
    }

    /**
     * 认证配置
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String name = token.getPrincipal().toString();
        if(StringUtils.isEmpty(name)) return null;

        User user = userLoginService.getUser(name);
        if(user == null){
            return null;
        }else {
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(name, user.getPassword().toString(), user.getName().toString());
            return simpleAuthenticationInfo;
        }
    }
}
