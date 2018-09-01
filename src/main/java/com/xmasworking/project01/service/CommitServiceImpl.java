package com.xmasworking.project01.service;

import com.xmasworking.project01.entity.Commit;
import com.xmasworking.project01.repository.CommitRepository;
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
public class CommitServiceImpl implements CommitService {

    @Autowired
    CommitRepository commitRepository;

    @Override
    public int countByUserid(Long userid){
        return commitRepository.countByUserid(userid);
    }

    @Override
    public int countByShowid(Long showid){
        return commitRepository.countByShowid(showid);
    }

    @Override
    public long countAll(){
        return commitRepository.count();
    }

    @Override
    public List<Commit> save(List<Commit> list){
        return commitRepository.save(list);
    }

    @Override
    public List<Commit> findAll(){
        return commitRepository.findAll();
    }

}
