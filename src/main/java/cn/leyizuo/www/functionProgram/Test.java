package cn.leyizuo.www.functionProgram;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Test {
    public static void main(String args[]){
//        List<User> userList = StaticCollection.getTUsers();
//        List<String> users=Chapter3Question.getStringList(userList);
//        List<User> userList1 = Chapter3Question.getUser(userList);
//        Integer[] arr = {1,2,3,4,5,4,5,41};
//        List<Integer> integers= Arrays.asList(arr);
//        int result = Chapter3Question.addUp(integers.stream());
//        System.out.println(users.toString()+" "+userList1.toString()+" "+result);
//        int result1=Chapter3Question.addAge(userList);
//        System.out.println("总体年龄"+result1);
//        String ss="1sfsdfsdf";
//        int result = Chapter3Question.judgeLowercase(ss);
//        System.out.println(result);
        //Arrays.asList();
        List<String> list= Arrays.asList("assdqwAAA","AAAdsds","AAAAAAdfgdfgd","dsafsdfssdfsdf");
        Optional<String> string=Chapter3Question.maxLowercaseString(list);
        if(string.isPresent()){
            String str=string.get();
            System.out.println(str);
        }

    }
}
