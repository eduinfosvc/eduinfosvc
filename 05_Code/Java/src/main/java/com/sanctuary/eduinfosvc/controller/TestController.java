package com.sanctuary.eduinfosvc.controller;

import com.sanctuary.eduinfosvc.domain.User;
import com.sanctuary.eduinfosvc.service.TestService;
import com.sanctuary.eduinfosvc.util.ErrorInfo;
import com.sanctuary.eduinfosvc.util.Info;
import com.sanctuary.eduinfosvc.util.SuccessInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@CrossOrigin
public class TestController {

    @Autowired
    TestService testService;

    // 测试
    @RequestMapping(value="/test", method = RequestMethod.POST)
    @ResponseBody
    public Info login(@RequestBody User user){
        System.out.println("*** 测试 ***");
        System.out.println(user);

        User newUser = testService.login(user);
        if(newUser.getId() != 0){
            System.out.println("*** 登录成功 ***");

            Map<String,String> userId = new HashMap<String,String>();
            userId.put("id", String.valueOf(newUser.getId()));
            userId.put("name", newUser.getUserName());
            userId.put("role", String.valueOf(newUser.getRole()));
            System.out.println(newUser);

            Object[] data = new Object[]{userId};
            SuccessInfo successInfo = new SuccessInfo(data);
            return successInfo;
        }else{
            System.out.println("*** 登录失败 ***");
            return new ErrorInfo(400,"暂无该用户");
        }
    }
}
