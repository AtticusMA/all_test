package cn.leyizuo.www.entity;

import java.util.List;

public class Office {
    private Long id;
    //部门名称
    private String name;
    //负责人
    private String userId;
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Office(){
        super();
    }

    public Office(long id,String name,String head){
        this.id = id;
        this.name = name;
        this.userId = head;
    }

    @Override
    public String toString() {
        return "Office{" +
                "users=" + users +
                '}';
    }
}
