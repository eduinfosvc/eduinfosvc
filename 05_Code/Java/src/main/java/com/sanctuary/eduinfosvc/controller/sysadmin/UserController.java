package com.sanctuary.eduinfosvc.controller.sysadmin;

import com.sanctuary.eduinfosvc.domain.Organize;
import com.sanctuary.eduinfosvc.domain.Page;
import com.sanctuary.eduinfosvc.domain.User;
import com.sanctuary.eduinfosvc.service.sysadmin.UserService;
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
public class UserController {
    @Autowired
    UserService userService;

    // 用户：查询用户（页数限定+全部 / 页数限定+名字模糊）
    @RequestMapping(value="/users", method = RequestMethod.GET)
    @ResponseBody
    public Info queryUsers(String name, Page page){
        // if判断可推迟到mapper文件里进行(但为了功能点在本层就可体现，故在此冗余书写)
        if(name == null){
            System.out.println("*** 用户：查询指定页数用户 ***");
            page.setBegin( (page.getPageNum()-1) * page.getPageSize());
            System.out.println(page);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("page", page);

            List<User> users = userService.queryUsers(map);
            if(!users.isEmpty()){
                for(User user: users) System.out.println(user);
            }

            Map<String,Integer> nums = new HashMap<String,Integer>();
            nums.put("total", userService.queryUsersNum(name));
            System.out.println(nums.get("total"));

            Object[] data = new Object[]{nums, users};
            SuccessInfo successInfo = new SuccessInfo(data);
            return successInfo;
        }else{
            System.out.println("*** 用户：查询指定页数和名称用户 ***");
            page.setBegin( (page.getPageNum()-1) * page.getPageSize());
            System.out.println(page);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("name", name);
            map.put("page", page);

            List<User> users = userService.queryUsersByName(map);
            if(!users.isEmpty()){
                for(User user: users) System.out.println(user);
            }

            Map<String,Integer> nums = new HashMap<String,Integer>();
            nums.put("total", userService.queryUsersNum(name));
            System.out.println(nums.get("total"));

            Object[] data = new Object[]{nums, users};
            SuccessInfo successInfo = new SuccessInfo(data);
            return successInfo;
        }
    }

    // 用户：查询指定ID用户
    @RequestMapping(value="/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Info queryUserById(@PathVariable("id") int userId){
        System.out.println("*** 用户：查询指定ID用户 ***");
        System.out.println(userId);

        User user = userService.queryUserById(userId);
        if(user != null){
            System.out.println(user);
            Object[] data = new Object[]{user};
            SuccessInfo successInfo = new SuccessInfo(data);
            return successInfo;
        }else{
            return new ErrorInfo(500, "无此用户");
        }

    }

    // 用户：注册用户
    @RequestMapping(value="/user", method = RequestMethod.POST)
    @ResponseBody
    public Info addUser(@RequestBody User user){
        System.out.println("*** 用户：注册用户 ***");
        System.out.println(user);

        if(userService.addUser(user)){
            return new SuccessInfo();
        }else{
            return new ErrorInfo(500, "手机号已被注册");
        }
    }

    // 用户：修改用户（禁用 / 修改部分信息）
    @RequestMapping(value="/user", method = RequestMethod.PUT)
    @ResponseBody
    public Info alterUser(@RequestBody User user){
        System.out.println("*** 用户：修改用户 ***");
        System.out.println(user);

        if(userService.alterUser(user)){
            return new SuccessInfo();
        }else{
            return new ErrorInfo(500, "修改失败");
        }
    }

    // 组织：查询组织（全部）
    @RequestMapping(value="/user/organizes", method = RequestMethod.GET)
    @ResponseBody
    public Info queryOrganizes(){
        System.out.println("*** 组织：查询全部组织 ***");

        List<Organize> organizes = userService.queryOrganizes();
        if(!organizes.isEmpty()){
            for(Organize organize: organizes) System.out.println(organize);
        }

        Object[] data = new Object[]{organizes};
        SuccessInfo successInfo = new SuccessInfo(data);
        return successInfo;
    }
}
