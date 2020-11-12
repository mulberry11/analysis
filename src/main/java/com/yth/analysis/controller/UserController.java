package com.yth.analysis.controller;

import com.yth.analysis.dto.UserDTO;
import com.yth.analysis.model.User;
import com.yth.analysis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    //跳转到角色管理页面
    @GetMapping("userManager")
    public String userManager(){
        return "user";
    }

    /**
     *
     * ajax查询用户列表
     * @return
     */
    @GetMapping("userList")
    @ResponseBody
    public List<UserDTO> userlist(){
        return userService.findUserList();
    }


    //添加角色功能
    @PostMapping("addUser")
    @ResponseBody
    public String addUser(Model model, User user){
        user.setCreateTime(new Date());
        Integer addUser = userService.addUser(user);
        if (addUser!=1)
            return "添加成功!";
        return "添加失败!";
    }
}
