package cn.leyizuo.www.generictype;

public class Pair<T> {
    private T first;
    private T second;

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public static void printPairObject(Pair<? extends Employeer> pair){
        System.out.println(pair.getFirst().getName()+" "+pair.getSecond().getName());
    }
}

class Employeer{
    private  String name;
    private  double salary;

    public Employeer(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

//继承用于测试<? extends T>或者<? super T>
class Manager extends Employeer{
    public Manager(String name,double salary){
        super(name,salary);
    }
}
//class Manager{
//    private String original;
//    private String level;
//
//    public String getOriginal() {
//        return original;
//    }
//
//    public void setOriginal(String original) {
//        this.original = original;
//    }
//
//    public String getLevel() {
//        return level;
//    }
//
//    public void setLevel(String level) {
//        this.level = level;
//    }
//
//    public Manager(String original, String level) {
//        this.original = original;
//        this.level = level;
//    }
//}

class President extends Manager{
    public President(String name, double salary) {
        super(name, salary);
    }
}