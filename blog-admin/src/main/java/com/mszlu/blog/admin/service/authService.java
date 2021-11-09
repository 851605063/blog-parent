package com.mszlu.blog.admin.service;

import com.mszlu.blog.admin.pojo.Admin;
import com.mszlu.blog.admin.pojo.Permission;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: WJQ
 * @date 2021-10-07 22:03
 */
@Service
public class authService {
    @Autowired
    private AdminService adminService;

    public  boolean auth(HttpServletRequest request, Authentication authentication){
        //权限认证
        String requestURI = request.getRequestURI();//拿到请求路径
        requestURI= StringUtils.split(requestURI,'?')[0];//匹配带请求参数的情况
        if(StringUtils.startsWith(requestURI,"/admin/permission/delete"))
            requestURI="/admin/permission/delete";
        Object principal = authentication.getPrincipal();//拿到当前登录用户
        if(principal==null||"anonymousUser".equals(principal))//判断是否为空或者是否为匿名用户
            return false;
        UserDetails userDetails=(UserDetails) principal;
        String username = userDetails.getUsername();
        Admin admin = adminService.findAdminByUsername(username);
        if(admin==null)
            //未登录
            return false;
        if(1==admin.getId())
            //超级管理员
            return true;
        Long id = admin.getId();
        List<Permission> permissionList=this.adminService.findPermissionByAdminId(id);
        for (Permission permission : permissionList) {
            if(requestURI.equals(permission.getPath()))
                return true;
        }
        return false;
    }
}
