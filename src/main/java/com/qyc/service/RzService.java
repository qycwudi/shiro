package com.qyc.service;

import com.qyc.bean.Permission;
import com.qyc.bean.Users;
import com.qyc.repository.Repository;
import com.qyc.repository.Repository1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author qyc
 * @time 2020/4/19 - 17:54
 */
@Service
public class RzService {
    @Autowired
    private Repository repository;
    public Users getUsers(String username){
        return repository.findByUsername(username);
    }
    @Autowired
    private Repository1 repository1;
    public Permission getPermission(String uid){
        return repository1.findByUid(uid);
    }
}
