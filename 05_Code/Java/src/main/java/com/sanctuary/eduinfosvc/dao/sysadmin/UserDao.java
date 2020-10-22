package com.sanctuary.eduinfosvc.dao.sysadmin;

import com.sanctuary.eduinfosvc.domain.Organize;
import com.sanctuary.eduinfosvc.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserDao {

    // 用户：查询总量
    int queryUsersNum(String name);

    // 用户：查询指定页数用户
    List<User> queryUsers(Map<String, Object> map);

    // 用户：查询指定页数和名称用户
    List<User> queryUsersByName(Map<String, Object> map);

    // 组织：查询指定ID用户
    User queryUserById(int userId);

    // 用户：增加用户
    int addUser(User user);

    // 栏目权限：增加用户初始栏目权限
    int addPermissions(Map<String, Object> map);

    // 用户：修改用户
    int alterUser(User user);

    // 组织：查询父组-基本信息
    List<Organize> queryOrganizes();

    // 组织：查询指定父亲-儿子信息
    List<Organize> getOrganizeChildren(int fatherOrganizeId);
}
