package cn.leyizuo.www.entity;

public class User implements  Comparable<User> {
    private  long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private String name;
    private String password;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public User(){
        super();
    }

    public User(Long id,String name,String password,int age){
        this.id = id;
        this.name= name;
        this.password=password;
        this.age=age;
    }

    //实现的时候直接使用了排序的算法
    @Override
    public int compareTo(User o) {
        if(o.age>this.age){
            return 1;
        }else if(o.age<this.age){
            return -1;
        }else
            return 0;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
