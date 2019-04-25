package cn.leyizuo.www.entity;

import java.util.List;

public class Company {
    //公司Id
    private long id;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    //公司法人
    private String userid;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //公司名称
    private String name;
    public List<Office> getOffices() {
        return offices;
    }

    public void setOffices(List<Office> offices) {
        this.offices = offices;
    }

    public Company(){
        super();
    }

    public Company(Long id,String name,String userid){
        this.id = id;
        this.name = name;
        this.userid = userid;
    }

    private List<Office> offices;

    @Override
    public String toString() {
        return "Company{" +
                "id='" + id + '\'' +
                ", userid='" + userid + '\'' +
                ", name='" + name + '\'' +
                ", offices=" + offices +
                '}';
    }
}
