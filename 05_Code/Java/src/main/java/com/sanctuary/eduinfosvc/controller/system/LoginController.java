package com.sanctuary.eduinfosvc.controller.system;

import com.sanctuary.eduinfosvc.domain.Page;
import com.sanctuary.eduinfosvc.domain.User;
import com.sanctuary.eduinfosvc.service.admin.PermissionService;
import com.sanctuary.eduinfosvc.service.system.LoginService;
import com.sanctuary.eduinfosvc.util.ErrorInfo;
import com.sanctuary.eduinfosvc.util.Info;
import com.sanctuary.eduinfosvc.util.SuccessInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
@RequestMapping("/api/")
public class LoginController {

    @Autowired
    LoginService loginService;

    // 登录（查询）
    @RequestMapping(value="/login", method = RequestMethod.POST)
    @ResponseBody
    public Info login(@RequestBody User loginUser){
        System.out.println("*** 登录 ***");
        System.out.println(loginUser);

        User user = loginService.login(loginUser);
        if(user != null){
            Object[] data = new Object[]{user};
            SuccessInfo successInfo = new SuccessInfo(data);
            System.out.println(user);
            return successInfo;
        }else{
            return new ErrorInfo();
        }

    }
}
