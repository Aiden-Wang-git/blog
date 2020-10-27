package com.wj.blog.service.serviceImpl;

import com.wj.blog.dao.UserRepository;
import com.wj.blog.po.User;
import com.wj.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
*@Author: Wang Jun
*@Description:
*@Date: 2020/10/23 10:33
*/
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    /*
    * @Description
    * @Author  WangJun
    * @Date   2020/10/23 10:34
    * @Params [username, password]
    * @Return com.wj.blog.po.User
    * @Exception
    */
    @Override
    public User checkUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username,password);
        return user;
    }
}
