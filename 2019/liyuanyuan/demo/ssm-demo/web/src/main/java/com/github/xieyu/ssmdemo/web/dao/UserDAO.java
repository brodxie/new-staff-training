package com.github.xieyu.ssmdemo.web.dao;

import com.github.xieyu.ssmdemo.web.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xieyu
 */
@Repository
public interface UserDAO {
    List<User> listAll();

    User getByUsername(@Param("username") String username);
}
