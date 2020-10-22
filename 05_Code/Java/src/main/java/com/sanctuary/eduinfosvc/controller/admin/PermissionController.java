package com.sanctuary.eduinfosvc.controller.admin;

import com.sanctuary.eduinfosvc.domain.Column;
import com.sanctuary.eduinfosvc.domain.Page;
import com.sanctuary.eduinfosvc.domain.User;
import com.sanctuary.eduinfosvc.service.admin.PermissionService;
import com.sanctuary.eduinfosvc.service.sysadmin.OrganizeService;
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
public class PermissionController {

    @Autowired
    PermissionService permissionService;

    // 用户：查询用户（页数限定+全部）
    @RequestMapping(value="/permission/users/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Info queryOrganizes(Page page, @PathVariable("id") int organizeId){
        System.out.println("*** 用户：查询指定页数用户 ***");
        page.setBegin( (page.getPageNum()-1) * page.getPageSize());
        System.out.println(page);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("page", page);
        map.put("organizeId", organizeId);

        List<User> users = permissionService.queryUsers(map);
        if(!users.isEmpty()){
            for(User user: users) System.out.println(user);
        }

        Map<String,Integer> nums = new HashMap<String,Integer>();
        nums.put("total", permissionService.queryUsersNum(organizeId));
        System.out.println(nums.get("total"));

        Object[] data = new Object[]{nums, users};
        SuccessInfo successInfo = new SuccessInfo(data);
        return successInfo;
    }

    // 栏目权限：查询指定ID用户的栏目权限
    @RequestMapping(value="/permission/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Info queryColumns(@PathVariable("id") int userId){
        System.out.println("*** 栏目权限：查询指定ID用户的栏目权限 ***");

        List<Column> columns = permissionService.queryColumns(userId);
        if(!columns.isEmpty()){
            for(Column column: columns) System.out.println(column);
        }

        Object[] data = new Object[]{columns};
        SuccessInfo successInfo = new SuccessInfo(data);
        return successInfo;
    }

    // 栏目权限：修改指定ID用户的栏目权限
    @RequestMapping(value="/permission/user/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Info alterColumns(@PathVariable("id") int userId, @RequestBody List<Column> columns){
        System.out.println("*** 栏目权限：修改指定ID用户的栏目权限 ***");
        System.out.println(columns);
        System.out.println(userId);

        if(permissionService.alterColumns(userId, columns)){
            return new SuccessInfo();
        }else{
            return new ErrorInfo(500, "修改失败");
        }
    }

}
