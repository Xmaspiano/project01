package com.xmasworking.project01.service;

import com.xmasworking.project01.entity.Commit;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author XmasPiano
 * @date 2018/8/31 - 下午4:19
 * Created by IntelliJ IDEA.
 */
public interface CommitService {
    int countByUserid(Long userid);

    int countByShowid(Long showid);

    long countAll();

    List<Commit> save(List<Commit> list);

    List<Commit> findAll();
}
