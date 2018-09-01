package com.xmasworking.project01.repository;

import com.xmasworking.project01.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 *
 * @author XmasPiano
 * @date 2018/8/31 - 下午4:17
 * Created by IntelliJ IDEA.
 */
public interface UserInfoRepository
        extends JpaRepository<UserInfo, Long> {

    /**
     * 依据手机号查询用户
     * @param tel
     * @return
     */
    UserInfo findUserInfoByTel(String tel);
}
