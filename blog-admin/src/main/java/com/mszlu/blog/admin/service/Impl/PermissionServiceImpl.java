package com.mszlu.blog.admin.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mszlu.blog.admin.mapper.PermissionMapper;
import com.mszlu.blog.admin.model.PageParams;
import com.mszlu.blog.admin.pojo.Permission;
import com.mszlu.blog.admin.service.PermissionService;
import com.mszlu.blog.admin.vo.PageResult;
import com.mszlu.blog.admin.vo.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: WJQ
 * @date 2021-10-02 13:08
 */
@Service
public class PermissionServiceImpl implements PermissionService {
      @Autowired
      private PermissionMapper permissionMapper;
    @Override
    public Result listPermission(PageParams params) {
        /**
         * 需要查询权限表返回list
         *
         */
        Page<Permission> page=new Page<>(params.getCurrentPage(),params.getPageSize());
        LambdaQueryWrapper<Permission> queryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(params.getQueryString()))
            queryWrapper.eq(Permission::getName,params.getQueryString());
        Page<Permission> permissionPage = permissionMapper.selectPage(page, queryWrapper);
        PageResult<Permission> pageResult = new PageResult<>();
        pageResult.setList(permissionPage.getRecords());
        pageResult.setTotal(permissionPage.getTotal());
        return  Result.success(pageResult);
    }

    @Override
    public Result addPermission(Permission permission) {
        permissionMapper.insert(permission);
        return Result.success(null);
    }

    @Override
    public Result deletePermission(Integer id) {
        permissionMapper.deleteById(id);
        return Result.success(null);
    }

    @Override
    public Result updatePermission(Permission permission) {
        permissionMapper.updateById(permission);
        return Result.success(null);
    }
}
