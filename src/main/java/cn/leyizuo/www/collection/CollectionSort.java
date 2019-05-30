package cn.leyizuo.www.collection;


import cn.leyizuo.www.entity.User;

import java.util.*;

public class CollectionSort {
    public static void main(String args[]){
        List<User> userList = StaticCollection.getTUsers();

        userList.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                if(o1.getAge()>o2.getAge()){
                    return 1;
                }else if(o1.getAge() < o2.getAge()){
                    return -1;
                }else
                    //如果岁数相同使用姓名排序
                    return o1.getName().compareTo(o2.getName());
            }
        });
//        for(User user:userList){
//            System.out.println(user.getName()+user.getAge()+user.getPassword());
//        }
        Set<User> userSet= new HashSet<>();
        userSet.add(new User(1L,"lipe","aaadd",17));
        userSet.add(new User(2L,"lipe","aaadd",11));
        userSet.add(new User(3L,"lipe","aaadd",19));
        userSet.add(new User(4L,"lipe","aaadd",10));
        userSet.add(new User(5L,"liwei","aaadd",10));
        List<User> userList1= StaticCollection.getTUsers();
        userSet =new HashSet<>(userList1);

        List<User> list = new ArrayList<User>(userSet);

        Collections.sort(list);
//        for(User user:list){
//            System.out.println(user.getName()+user.getAge()+user.getPassword());
//        }

        Map<String, Integer> us = new HashMap<String, Integer>();
        // MapTest<String, Integer> us = new TreeMap<String, Integer>();
        us.put("f1", 12);
        us.put("f2", 13);
        us.put("f5", 22);
        us.put("f4", 42);
        us.put("f3", 15);
        us.put("f8", 21);
        us.put("f6", 123);
        us.put("f7", 1);
        us.put("f9", 19);
        System.out.println(us.toString());
        //TreeMap可以按照key进行排序
        //System.out.println(new TreeMap<String, Integer>(us));

        //按照map的value进行排序
        Set<Map.Entry<String, Integer>> ks = us.entrySet();
        List<Map.Entry<String, Integer>> maplist = new ArrayList<Map.Entry<String, Integer>>(ks);
        Collections.sort(maplist, new Comparator<Map.Entry<String, Integer>>() {

            @Override
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                if (o1.getValue() < o2.getValue())
                    return -1;
                else if (o1.getValue() > o2.getValue())
                    return 1;
                return 0;
            }
        });
        System.out.println(maplist);
    }
}
