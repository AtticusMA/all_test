package cn.leyizuo.www.functionProgram;

import cn.leyizuo.www.collection.StaticCollection;
import cn.leyizuo.www.entity.Office;

import java.util.ArrayList;
import java.util.List;

public class RefactorStream {
    public static void main(String args[]){
        List<Integer> oldUserAgeList = new ArrayList<>();
        List<Office> officeList = StaticCollection.getOffice();
        //原始方案
//        for(Office office:officeList){
//            List<User> userList = office.getUsers();
//            for(User user:userList){
//                if(user.getAge()>27){
//                    oldUserAgeList.add(user.getAge());
//                }
//            }
//        }
        //第一次重构
        officeList.stream()
                .forEach(office -> {office.getUsers().stream()
                        .forEach(user ->
                        {if(user.getAge()>27)
                        { int age=user.getAge();oldUserAgeList.add(age);
                        }})
                ; }
                );
        //第二次重构
//        officeList.stream()
//                .forEach(office->{
//                    office.getUsers().stream()
//                            .filter(user -> user.getAge()>27)
//                            .map(user -> user.getAge())
//                            .forEach(age->oldUserAgeList.add(age));
//                });
        //第三次重构
//        officeList.stream()
//                .flatMap(office -> office.getUsers().stream())
//                .filter(user->user.getAge()>27)
//                .map(user->user.getAge())
//                .forEach(age->oldUserAgeList.add(age));
        //第四次重构
//        List<Integer> newAgeList=officeList.stream()
//                .flatMap(office -> office.getUsers().stream())
//                .filter(user -> user.getAge()>27)
//                .map(user -> user.getAge())
//                .collect(Collectors.toList());
        System.out.println(oldUserAgeList.toString());
        //System.out.println(newAgeList.toString());
    }
}
