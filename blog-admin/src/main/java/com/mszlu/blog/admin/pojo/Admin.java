package com.mszlu.blog.admin.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author: WJQ
 * @date 2021-10-07 21:54
 */
@Data
public class Admin {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String username;
    private String password;

}
