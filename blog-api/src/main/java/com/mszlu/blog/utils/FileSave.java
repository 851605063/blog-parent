package com.mszlu.blog.utils;

import com.mszlu.blog.vo.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

/**
 * @author: WJQ
 * @date 2021-11-11 16:42
 */
@Component
public class FileSave {
    public Boolean save(MultipartFile file, String path,String fileName) {
        System.out.println(path);
        OutputStream os = null;
        InputStream inputStream = null;
        String originalFilename = file.getOriginalFilename();
        //唯一的文件名称
        System.out.println(fileName);
        File dest = new File(path + fileName);
        try {
            file.transferTo(dest);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
       return false;
    }
}
