package cn.leyizuo.www.functionProgram;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Chapter5Test {
    public static void main(String args[]){
        Set<Integer> integerSet = new HashSet<Integer>(Arrays.asList(4,3,2,1));
        List<Integer> sortedList = integerSet.stream().sorted().collect(Collectors.toList());
        //Assert.assertQquals(Arrays.asList(1,2,3,4),sortedList);
    }
}
