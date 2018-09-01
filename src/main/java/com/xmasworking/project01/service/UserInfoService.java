package com.xmasworking.project01.service;

import com.xmasworking.project01.entity.UserInfo;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author XmasPiano
 * @date 2018/8/31 - 下午4:19
 * Created by IntelliJ IDEA.
 */
public interface UserInfoService {
    List<UserInfo> findAll();

    UserInfo findUserInfoByTel(String tel);

    UserInfo findById(Long id);
}
