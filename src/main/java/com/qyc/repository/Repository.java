package com.qyc.repository;

import com.qyc.bean.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author qyc
 * @time 2020/4/19 - 15:28
 */
public interface Repository extends JpaRepository<Users,Integer> {
    public Users findByUsername(String username);
}
