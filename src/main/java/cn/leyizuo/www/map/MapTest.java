package cn.leyizuo.www.map;

import java.util.*;

public class MapTest {
    public static void main(String args[]){
        //hashmap
        Map<String,String> map = new HashMap<>();
        map.put("a","macheng");
        map.put("z","chenggong");
        map.put("c","lixiao");
        map.put("d","tianshi");
        map.put("e","baichi");
        map.put("g","meilin");
        map.put("f","zhongkeruan");
        map.put("j","jjjjj");
        map.put("h","rilelele");
        map.put("b","sddsd");
        System.out.println(map.get("a"));
        //这个删除就有意思啦，怎么会删除之后，迭代就报错;确实删除了
        //map.remove("a");
        System.out.println(map.size());
        //Iterator<Map.Entry<String,String>> entryIterator = map.entrySet().iterator();
        System.out.println("===========================hashMap===================================");
        System.out.println(new Date());
        //迭代的数量也不对，将删除a取消，迭代的数量也是不对的。
        for(Map.Entry<String,String> entry:map.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
//        while(entryIterator.hasNext()){
//            System.out.println(entryIterator.next().getKey()+":"+entryIterator.next().getValue());
//        }
        System.out.println(new Date());
        System.out.println("===========================end===================================");
        map.clear();
        if(map.isEmpty()){
            System.out.println("hashmap已经清空");
        }

        //linkedhashmap

        Map<String,String> linkedhashmap = new LinkedHashMap<>();
        linkedhashmap.put("a","macheng");
        linkedhashmap.put("z","chenggong");
        linkedhashmap.put("c","lixiao");
        linkedhashmap.put("d","tianshi");
        linkedhashmap.put("e","baichi");
        linkedhashmap.put("g","meilin");
        linkedhashmap.put("f","zhongkeruan");
        linkedhashmap.put("j","jjjjj");
        linkedhashmap.put("h","rilelele");
        linkedhashmap.put("b","sddsd");

        //Iterator<java.util.Map.Entry<String,String>> linkedEntryIterator = linkedhashmap.entrySet().iterator();
        //Iterator<Map.Entry<String,String>> linkedEntryIterator = linkedhashmap.entrySet().iterator();
        System.out.println("===========================linkedTreeMap===================================");
        System.out.println(new Date());
        for(Map.Entry<String,String> entry:linkedhashmap.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
//        while(linkedEntryIterator.hasNext()){
//            Map.Entry<String,String> me = linkedEntryIterator.next();
//            System.out.println(me.getKey()+":"+me.getValue());
//            //System.out.println(entryIterator.next().getKey()+":"+entryIterator.next().getValue());
//        }
        System.out.println(new Date());
        //treemap

        Map<String,String> treeMap = new TreeMap<String,String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.compareTo(o2)>0){
                    return 1;
                }else if(o1.compareTo(o2)<0){
                    return -1;
                }else{
                 return 0;
                }
            }
        });
        treeMap.put("a","macheng");
        treeMap.put("z","chenggong");
        treeMap.put("c","lixiao");
        treeMap.put("d","tianshi");
        treeMap.put("e","baichi");
        treeMap.put("g","meilin");
        treeMap.put("f","zhongkeruan");
        treeMap.put("j","jjjjj");
        treeMap.put("h","rilelele");
        treeMap.put("b","sddsd");

        Iterator<java.util.Map.Entry<String,String>> treeEntryIterator = treeMap.entrySet().iterator();
        System.out.println("===========================treeMap===================================");
        System.out.println(new Date());
//        while(treeEntryIterator.hasNext()){
//            System.out.println(treeEntryIterator.next().getKey()+":"+treeEntryIterator.next().getValue());
//        }
        for(Map.Entry<String,String> entry:treeMap.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        System.out.println(new Date());
    }
}

//总结：别用迭代器迭代map，一定要用for迭代，切记切记
