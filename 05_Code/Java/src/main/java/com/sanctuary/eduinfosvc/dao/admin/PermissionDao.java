package com.sanctuary.eduinfosvc.dao.admin;

import com.sanctuary.eduinfosvc.domain.Column;
import com.sanctuary.eduinfosvc.domain.Organize;
import com.sanctuary.eduinfosvc.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface PermissionDao {

    // 用户：查询总量
    int queryUsersNum(int organizeId);

    // 用户：查询指定页数用户
    List<User> queryUsers(Map<String, Object> map);

    // 栏目权限：查询指定ID用户的栏目权限
    List<Column> queryColumns(int userId);

    // 栏目权限：修改指定ID用户的栏目权限
    int alterColumns(Map<String, Object> map);
}
