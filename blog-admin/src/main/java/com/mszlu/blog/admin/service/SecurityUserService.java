package com.mszlu.blog.admin.service;

import com.mszlu.blog.admin.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @author: WJQ
 * @date 2021-10-02 22:42
 */
@Component
public class SecurityUserService implements UserDetailsService {
    @Autowired
    private  AdminService adminService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //当登陆的时候会把username传递到这里
        //通过username查询admin表，如果admin存在，将密码告诉spring Security
        //如果不存在，返回null，认证失败了
        Admin admin = adminService.findAdminByUsername(username);
        if(admin==null)
            return null;
        UserDetails userDetails = new User(username,admin.getPassword(),new ArrayList<>());
        return userDetails;
    }
}
