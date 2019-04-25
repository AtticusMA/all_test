package cn.leyizuo.www.functionProgram;

import cn.leyizuo.www.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class CollectionStream {
    public static void main(String args[]){
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
        //System.out.println(userList.stream().filter(user -> user.getAge()>13).count());
        //return 中的判定条件没有执行
        //userList.stream().filter(user -> {System.out.println(user.getName()); return user.getAge()>133; }).count();
        //collect(Collectors.toList())使流的实例生成一个list
        //List<String> collected = Stream.of("a","b","c").collect(Collectors.toList());
        //map可以转换值
        //List<String> collected1 = Stream.of("1a","b","c").map(string->string.toUpperCase()).collect(toList());
        //System.out.println(collected1.stream().filter(x->isDigit(x.charAt(0))).collect(toList()));
        //assertEquals(Arrays.asList("a","b","c"),collected);
        //flatMap合并两个列表
//        List<Integer> to = Stream.of(asList(1,2),asList(3,4)).flatMap(number ->number.stream()).collect(toList());
//        System.out.println(to.toString());
        //min需要Comparator
//        User user=userList.stream().min(Comparator.comparing(x->x.getAge())).get();
//        System.out.println(user.toString());
        //reduce模式参数是接口函数BinartOperator
        int x = Stream.of(1,2,3,5,7,87,8).reduce(0,(ba, la)-> ba+la);
//        System.out.println(x);
        //生成一个属性的列表
        List<String> username = userList.stream().filter(user -> user.getAge()>13).map(user -> user.getName()).collect(toList());
        System.out.println(username.toString());

    }


}
