package com.yth.analysis.service;

import com.yth.analysis.dto.UserDTO;
import com.yth.analysis.mapper.UserMapper;
import com.yth.analysis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired(required = true)
    private UserMapper userMapper;

    public User doLogin(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }

    public Integer addUser(User user) {
        return userMapper.insert(user);
    }

    public List<UserDTO> findUserList() {
        return userMapper.findUserList();
    }
}
