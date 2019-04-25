package cn.leyizuo.www.functionProgram;

import cn.leyizuo.www.entity.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Chapter3Question {
    //List<Interger> 加法
    public static int addUp(Stream<Integer> numbers){
        return numbers.reduce(0,(acc,a)->acc+a);
    }

    //对象两属性的列表
    public static List<String> getStringList(List<User> users){
        return users.stream().flatMap(user -> Stream.of(user.getName(),user.getPassword())).collect(toList());
    }

    //过滤
    public static List<User> getUser(List<User> users){
        return users.stream().filter(user ->user.getAge()>17).collect(toList());
    }

    //对象的属性的加法
    public static int addAge(List<User> users){
        return users.stream().map(user -> user.getAge()).reduce(0,(acc,value)->acc+value);
    }

    //判定字符串的小写字母个数
    public static int judgeLowercase(String str){
         return (int)str.chars().filter(Character::isLowerCase).count();
    }
    //选出字符串列表中，小写字符最多的字符串;这个牛逼，内嵌一个lambda表达，使用的是方法
    public static Optional<String> maxLowercaseString(List<String> str){
        return str.stream().max(Comparator.comparing(Chapter3Question::judgeLowercase));
    }

    public static <I,O> List<O> map(Stream<I> stream, Function<I,O> map){
        return stream.reduce(new ArrayList<O>(),(acc,x)->{
            //最终聚合的元素类型为new ArrayList<O>,首先根据reduce接口使用三个函数，第一个显示输出类型，第二个是BiFunction<U, ? super T, U> accumulator
            //操作两个参数的函数,本算法使用的是通过function将一个函数转换为另外一个函数，使用list将所有值add，但是最后怎么分为左右了，再addAll，
            List<O> newAcc=new ArrayList<>(acc);
            newAcc.add(map.apply(x));
            return newAcc;
        }, (List<O> left,List<O> right)->{
            List<O> newList=new ArrayList<>(left);
            newList.addAll(right);
            return newList;
        });
    }

    public static <I> List<I> filter(Stream<I> stream, Predicate<I> predicate){
        return stream.reduce(new ArrayList<I>(),(List<I> acc,I x)->{
            if(predicate.test(x)){
                List<I> newList = new ArrayList<>(acc);
                newList.add(x);
                return newList;
            }else{
                return acc;
            }
        }, Chapter3Question::combineLists);
    }

    public static <I> List<I> combineLists(List<I> left,List<I> right){
        List<I> newList= new ArrayList<I>(left);
        newList.addAll(right);
        return newList;
    }
}
