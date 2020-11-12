package com.yth.analysis.controller;

import com.yth.analysis.model.User;
import com.yth.analysis.service.FileInputService;
import com.yth.analysis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private FileInputService fileInputService;
    @GetMapping("/")
    public String login(){
        return "login";
    }
    @PostMapping("doLogin")
    public String doLogin(Model model,
                          @RequestParam(name = "id") Integer id,
                          @RequestParam(name = "password") String password,
                          HttpSession session){
        //根据id查询用户
        User loginUser = userService.doLogin(id);
        if (loginUser == null) {
            //用户为空返回错误信息返回登录页面
            model.addAttribute("message","用户id错误");
            return "login";
        }
        //验证密码
        if (!loginUser.getPassword().equals(password)) {
            //返回错误信息
            model.addAttribute("message","密码错误");
            return "login";
        }
        //登录用户写入session
        session.setAttribute("USER",loginUser);
        model.addAttribute("fileList",fileInputService.selectFileList());
        return "index";
    }
}
