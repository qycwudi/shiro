package com.qyc.bean;

/**
 * @author qyc
 * @time 2020/4/19 - 17:02
 */
public class People {
    private int id;
    private String name;

    public People(String name) {
        this.name = name;
    }

    public People() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
