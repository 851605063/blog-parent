package com.mszlu.blog.admin.controller;

import com.mszlu.blog.admin.model.PageParams;
import com.mszlu.blog.admin.pojo.Permission;
import com.mszlu.blog.admin.service.PermissionService;
import com.mszlu.blog.admin.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: WJQ
 * @date 2021-10-02 12:56
 */
@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private PermissionService permissionService;

    @PostMapping("/permission/permissionList")
    public  Result listPermission(@RequestBody PageParams params){

        return permissionService.listPermission(params);
    }

    @GetMapping ("/permission/delete/{id}")
    public  Result deletePermission(@PathVariable Integer id){

        return permissionService.deletePermission(id);
    }
    @PostMapping ("/permission/add")
    public  Result addPermission(@RequestBody Permission permission){

        return permissionService.addPermission(permission);
    }
    @PostMapping ("/permission/update")
    public  Result updatePermission(@RequestBody Permission permission){

        return permissionService.updatePermission(permission);
    }
}
