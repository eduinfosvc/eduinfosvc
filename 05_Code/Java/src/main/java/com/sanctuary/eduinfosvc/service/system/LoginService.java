package com.sanctuary.eduinfosvc.service.system;

import com.sanctuary.eduinfosvc.dao.admin.PermissionDao;
import com.sanctuary.eduinfosvc.dao.system.LoginDao;
import com.sanctuary.eduinfosvc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    LoginDao loginDao;

    // 登录（查询）
    public User login(User loginUser){
        return loginDao.login(loginUser);
    }

}
