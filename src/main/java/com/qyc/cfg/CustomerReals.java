package com.qyc.cfg;

import com.qyc.bean.Permission;
import com.qyc.bean.Users;
import com.qyc.service.RzService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.SimpleByteSource;
import org.springframework.beans.factory.annotation.Autowired;

//
///**
// * @author qyc
// * @time 2020/4/19 - 16:02
// */
////自定义realm  授权领域
public class CustomerReals extends AuthorizingRealm {
    @Autowired
    private RzService service;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("--------------------");
//        查询主身份信息
        String primary = (String) principalCollection.getPrimaryPrincipal();
        //查数据库
        Users users = service.getUsers(primary);
        Permission permission = service.getPermission(String.valueOf(users.getId()));
        //例子按照一个身份 ，实际情况应该为一个集合
        System.out.println("permission: "+permission.toString());
//        添加角色
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRole(permission.getPermission());
//      添加权限标识
        simpleAuthorizationInfo.addStringPermission("vip1:add");
        return simpleAuthorizationInfo;
    }
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        System.out.println("username: "+username);
        Users users = service.getUsers(username);
        System.out.println("users: "+users.toString());
        if(username.equals(users.getUsername())){
            return new SimpleAuthenticationInfo(username,users.getPassword(),new SimpleByteSource(username),this.getName());
        }
        return null;
    }

}
