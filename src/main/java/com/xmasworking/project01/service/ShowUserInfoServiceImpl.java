package com.xmasworking.project01.service;

import com.xmasworking.project01.entity.ShowUserInfo;
import com.xmasworking.project01.repository.ShowUserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author XmasPiano
 * @date 2018/8/30 - 下午3:31
 * Created by IntelliJ IDEA.
 */
@Service
public class ShowUserInfoServiceImpl implements ShowUserInfoService{

    @Autowired
    public ShowUserInfoRepository showUserInfoRepository;

    @Override
    public List<ShowUserInfo> findAll(){
        return showUserInfoRepository.findAll();
    }

    @Override
    public ShowUserInfo findById(Long id){
        return showUserInfoRepository.findOne(id);
    }

}
