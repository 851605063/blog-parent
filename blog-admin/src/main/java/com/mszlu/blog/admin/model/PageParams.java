package com.mszlu.blog.admin.model;

import lombok.Data;

/**
 * @author: WJQ
 * @date 2021-10-02 13:04
 */
@Data
public class PageParams {
    private Integer currentPage;
    private Integer pageSize;
    private String queryString;

}
