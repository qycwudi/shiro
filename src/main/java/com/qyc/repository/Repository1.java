package com.qyc.repository;

import com.qyc.bean.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author qyc
 * @time 2020/4/19 - 18:13
 */
public interface Repository1 extends JpaRepository<Permission,Integer> {
    public Permission findByUid(String Uid);
}
