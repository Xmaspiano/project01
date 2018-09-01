package com.xmasworking.project01.repository;

import com.xmasworking.project01.entity.Commit;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 *
 * @author XmasPiano
 * @date 2018/8/31 - 下午4:18
 * Created by IntelliJ IDEA.
 */
public interface CommitRepository
        extends JpaRepository<Commit, Long> {
    int countByUserid(Long userid);

    int countByShowid(Long showid);
}
