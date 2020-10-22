package com.sanctuary.eduinfosvc.dao.system;

import com.sanctuary.eduinfosvc.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoginDao {

    // 登录（查询）
    User login(User loginUser);

}
