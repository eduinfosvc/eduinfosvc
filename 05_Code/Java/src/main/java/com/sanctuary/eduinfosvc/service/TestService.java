package com.sanctuary.eduinfosvc.service;

import com.sanctuary.eduinfosvc.dao.TestDao;
import com.sanctuary.eduinfosvc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    TestDao testDao;

    // 测试
    public User login(User user){
        return testDao.findUser(user);
    }
}
