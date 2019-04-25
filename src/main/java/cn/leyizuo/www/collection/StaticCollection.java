package cn.leyizuo.www.collection;


import cn.leyizuo.www.entity.Company;
import cn.leyizuo.www.entity.Office;
import cn.leyizuo.www.entity.User;

import java.util.ArrayList;
import java.util.List;

public class StaticCollection {
    private Company company;
    private Office office;
    private User user;

    public static List<User> getTUsers(){
        List<User> userList = new ArrayList<>();
        userList.add(new User(1L,"lwwei","aaadd",24));
        userList.add(new User(2L,"mcheng","aaadd",30));
        userList.add(new User(3L,"tbao","aaadd",29));
        userList.add(new User(4L,"wjrui","aaadd",25));
        userList.add(new User(5L,"zlxing","aaadd",27));
        userList.add(new User(6L,"whcheng","aaadd",31));
        userList.add(new User(7L,"mdong","aaadd",28));
        userList.add(new User(8L,"zjhao","aaadd",26));
        userList.add(new User(9L,"wwshan","aaadd",18));
        userList.add(new User(10L,"dzyu","aaadd",32));
        userList.add(new User(11L,"jyue","aaadd",26));
        userList.add(new User(12L,"lyyan","aaadd",24));
        return userList;
    }

    public static List<User> getSaleUsers(){
        List<User> userList = new ArrayList<>();
        userList.add(new User(9L,"baqi","aaadd",26));
        userList.add(new User(10L,"tjun","aaadd",32));
        userList.add(new User(11L,"lzhu","aaadd",29));
        userList.add(new User(12L,"fming","aaadd",35));
        userList.add(new User(12L,"wxin","aaadd",21));
        return userList;
    }

    public static List<User> getManagementUser(){
        List<User> userList = new ArrayList<>();
        userList.add(new User(12L,"wxdong","aaadd",40));
        return userList;
    }

    public static List<Office> getOffice(){
        List<Office> officeList = new ArrayList<>();
        Office office = new Office(1L,"技术","dzyu");
        List<User> TuserList =getTUsers();
        office.setUsers(TuserList);
        officeList.add(office);
        Office office2 = new Office(2L,"销售","baqi");
        office2.setUsers(getSaleUsers());
        officeList.add(office2);
        Office office3 = new Office(2L,"管理","wxdong");
        office3.setUsers(getManagementUser());
        return officeList;
    }

    public static Company getCompany(){
        return new Company(1l,"瑞德合创","wxdong");
    }
}
