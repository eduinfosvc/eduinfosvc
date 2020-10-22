package com.sanctuary.eduinfosvc.service.sysadmin;

import com.sanctuary.eduinfosvc.dao.sysadmin.OrganizeDao;
import com.sanctuary.eduinfosvc.dao.sysadmin.UserDao;
import com.sanctuary.eduinfosvc.domain.Organize;
import com.sanctuary.eduinfosvc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    // 用户：查询总量
    public int queryUsersNum(String name){
        return userDao.queryUsersNum(name);
    }

    // 用户：查询指定页数用户
    public List<User> queryUsers(Map<String,Object> map){
        return userDao.queryUsers(map);
    }

    // 用户：查询指定页数和名称用户
    public List<User> queryUsersByName(Map<String,Object> map){
        return userDao.queryUsersByName(map);
    }

    // 用户：查询指定ID用户
    public User queryUserById(int userId){
        return userDao.queryUserById(userId);
    }

    // 用户：增加用户
    public boolean addUser(User user){
        try{
            if(userDao.addUser(user) > 0){
                System.out.println("*** userId: " + user.getId() + " ***");
                Map<String,Object> map = new HashMap<String, Object>();
                for(int i=1; i<=5; i++){
                    map.put("columnId", i);
                    map.put("userId", user.getId());
                    userDao.addPermissions(map);
                }
                return true;
            }
            else    return false;
        }catch (Exception e){
            System.out.println(e);
            System.out.println("*** 注册用户失败 ***");
            return false;
        }
    }

    // 用户：修改用户
    public boolean alterUser(User user){
        if(userDao.alterUser(user) > 0)    return true;
        else    return false;
    }

    // 组织：查询组织（全部）
    public List<Organize> queryOrganizes(){
        List<Organize> organizeFathers = userDao.queryOrganizes();
        for(Organize organizeFather: organizeFathers){
            organizeFather.setChildren(
                    userDao.getOrganizeChildren(organizeFather.getOrganizeId()));
            for(Organize organizeSon: organizeFather.getChildren()){
                organizeSon.setChildren(
                        userDao.getOrganizeChildren(organizeSon.getOrganizeId()));
            }
        }
        return organizeFathers;
    }

}
