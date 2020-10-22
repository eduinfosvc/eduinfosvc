package com.sanctuary.eduinfosvc.dao.sysadmin;

import com.sanctuary.eduinfosvc.domain.Organize;
import com.sanctuary.eduinfosvc.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface OrganizeDao {
    // 组织：查询总量 (查询全部父组)
    int queryOrganizesNum(String name);

    // 组织：查询指定页数父组-基本信息
    List<Organize> queryOrganizes(Map<String, Object> map);

    // 组织：查询指定页数和名称父组-基本信息
    List<Organize> queryOrganizesByName(Map<String, Object> map);

    // 组织：查询指定父亲-儿子信息
    List<Organize> getOrganizeChildren(int fatherOrganizeId);

    // 组织：增加组织
    int addOrganize(Organize organize);

    // 组织：修改组织
    int alterOrganize(Organize organize);

    // 组织：删除组织
    int deleteOrganize(int organizeId);

    // 组织：查询指定ID组织
    Organize queryOrganizeById(int organizeId);

    // 用户：查询指定ID组织的所有用户
    List<User> getUsers(int organizeId);
}
