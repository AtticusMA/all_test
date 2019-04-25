package cn.leyizuo.www.collection.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author： qiusheng
 * @Date： 2019/4/25 11:00
 * @DESCRIPTION：判断set中实现类的顺序性
 * @EMAIL： atticusma@hotmail.com
 */
public class SetSort {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("String1");
        set.add("String4");
        set.add("String3");
        set.add("String2");
        set.add("String5");
        set.forEach(e-> System.out.print(e+" "));
        System.out.println();


        //LinkedHashSet会保证元素的添加顺序
        Set<String> set2 = new LinkedHashSet<>();
        set2.add("String1");
        set2.add("String5");
        set2.add("String3");
        set2.add("String4");
        set2.add("String2");
        set2.forEach(e-> System.out.print(e+" "));
        System.out.println();


        //TreeSet保证元素自然顺序
        Set<String> set3 = new TreeSet<>();
        set3.add("String1");
        set3.add("String5");
        set3.add("String4");
        set3.add("String2");
        set3.add("String3");
        set3.forEach(e-> System.out.print(e+" "));

    }
}

