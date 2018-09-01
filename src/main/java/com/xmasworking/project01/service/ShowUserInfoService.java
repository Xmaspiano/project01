package com.xmasworking.project01.service;

import com.xmasworking.project01.entity.ShowUserInfo;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author XmasPiano
 * @date 2018/8/30 - 下午3:31
 * Created by IntelliJ IDEA.
 */
public interface ShowUserInfoService {

    List<ShowUserInfo> findAll();

    ShowUserInfo findById(Long id);
}
