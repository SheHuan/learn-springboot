package com.sn.springboot.dao;

import com.sn.springboot.pojo.Role;
import com.sn.springboot.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 功能：
 * 作者：SheHuan
 * 时间：2020/10/10 10:59
 */
@Repository
public interface UserDao {
    User getUserByName(String username);

    List<Role> getRolesByUserId(Long userId);
}
