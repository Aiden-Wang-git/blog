package com.wj.blog.service;

import com.wj.blog.po.User;

public interface UserService {
    User checkUser(String username,String password);
}
