package com.qyc.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author qyc
 * @time 2020/4/19 - 18:05
 */
@Entity
@Table(name = "permission")
public class Permission {
    @Id
    private int id;
    private String uid;
    private String permission;

    public Permission() {
    }

    public Permission(int id, String uid, String permission) {
        this.id = id;
        this.uid = uid;
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", permission='" + permission + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
