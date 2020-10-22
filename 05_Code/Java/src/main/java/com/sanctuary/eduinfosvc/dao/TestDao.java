package com.sanctuary.eduinfosvc.dao;

import com.sanctuary.eduinfosvc.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TestDao {

    // 测试
    User findUser(User user);
}
