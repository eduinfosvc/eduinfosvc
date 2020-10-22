package com.sanctuary.eduinfosvc.service.admin;

import com.sanctuary.eduinfosvc.dao.admin.PermissionDao;
import com.sanctuary.eduinfosvc.dao.sysadmin.OrganizeDao;
import com.sanctuary.eduinfosvc.domain.Column;
import com.sanctuary.eduinfosvc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PermissionService {

    @Autowired
    PermissionDao permissionDao;

    // 用户：查询总量
    public int queryUsersNum(int organizeId){
        return permissionDao.queryUsersNum(organizeId);
    }

    // 用户：查询指定页数用户
    public List<User> queryUsers(Map<String,Object> map){
        return permissionDao.queryUsers(map);
    }

    // 栏目权限：查询指定ID用户的栏目权限
    public List<Column> queryColumns(int userId){
        return permissionDao.queryColumns(userId);
    }

    // 栏目权限：修改指定ID用户的栏目权限
    public boolean alterColumns(int userId, List<Column> columns){
        if(!columns.isEmpty()){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("userId", userId);
            for(Column column: columns){
                map.put("columnId", column.getId());
                map.put("uploadPower", column.isUploadPower());
                map.put("checkPower", column.isCheckPower());
                if(permissionDao.alterColumns(map) <= 0)    return false;
            }
        }
        return true;
    }
}
