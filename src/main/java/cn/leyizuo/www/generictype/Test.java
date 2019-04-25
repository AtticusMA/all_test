package cn.leyizuo.www.generictype;

public class Test {
    public static void main(String args[]){
        Pair<Manager> pair = new Pair<>(new Manager("tiankong",2.14),new Manager("baichi",324.23));
        //Pair<Manager> pair2 = new Pair<Manager>(new Manager("tiankong","12"),new Manager("baichi","324.23"));
        //System.out.println(pair2.getFirst().getLevel()+" "+pair2.getSecond().getOriginal());
        Pair.printPairObject(pair);
    }
}
