package com.qyc.controller;

import com.qyc.bean.Users;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.subject.Subject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author qyc
 * @time 2020/4/19 - 15:26
 */
@Controller
public class UserController {
    @RequestMapping("/usersLogin")
    public String login(Users users){
        System.out.println("controller: "+users);

        Subject subject = SecurityUtils.getSubject();
        //new 令牌
        try{
            subject.login(new UsernamePasswordToken(users.getUsername(),users.getPassword()));
            return "redirect:/home";
        }catch (UnknownAccountException e){
            System.out.println("用户名错误");
        }catch (IncorrectCredentialsException e){
            System.out.println("密码错误");
        }
        return "redirect:/userlogin";
    }
    @RequestMapping("/userlogout")
    public String loginout(Users users){

        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/home";
    }


}
