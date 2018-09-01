package com.xmasworking.project01.service;

import com.xmasworking.project01.entity.UserInfo;
import com.xmasworking.project01.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author XmasPiano
 * @date 2018/8/31 - 下午4:20
 * Created by IntelliJ IDEA.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoRepository userInfoRepository;

    @Override
    public List<UserInfo> findAll(){
        return userInfoRepository.findAll();
    }

    @Override
    public UserInfo findUserInfoByTel(String tel){
        return userInfoRepository.findUserInfoByTel(tel);
    }

    @Override
    public UserInfo findById(Long id){
        return userInfoRepository.findOne(id);
    }
}
