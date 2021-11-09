package com.mszlu.blog.admin.service;

import com.mszlu.blog.admin.model.PageParams;
import com.mszlu.blog.admin.pojo.Permission;
import com.mszlu.blog.admin.vo.Result;

/**
 * @author: WJQ
 * @date 2021-10-02 13:07
 */
public interface PermissionService {
    Result listPermission(PageParams params);

    Result addPermission(Permission permission);

    Result deletePermission(Integer id);

    Result updatePermission(Permission permission);
}
