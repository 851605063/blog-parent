package com.mszlu.blog.admin.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: WJQ
 * @date 2021-11-09 21:31
 */
@Controller
public class LoginController {
//    @RequestMapping("/login")
//    public String login() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth instanceof AnonymousAuthenticationToken) {
//            return "login";
//        } else {
//            return "pages/main";
//        }
//    }

    @GetMapping("/")
    public String welcome() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth instanceof AnonymousAuthenticationToken) {
            System.out.println("未登录");
            return "login";
        } else {
            System.out.println("已登录");
            return "main";
        }
    }
}

