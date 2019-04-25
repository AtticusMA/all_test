package cn.leyizuo.www.functionProgram;

import cn.leyizuo.www.entity.Artist;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface Performance {

    String getName();

    Stream<Artist> getMusicians();

    default Stream<Artist> getAllMusicians(){
        //大哥这是拼接，题目的意思是将所有的音乐人的列表，判断是乐队还是如果是乐队就加组员，不是乐队就是用artist
        //return getMusicians().flatMap(artist -> {return concat(Stream.of(artist),artist.getMembers());});
        List<Artist> artists = new ArrayList<>();
        getMusicians().forEach(artist -> {
            if(artist.getName().startsWith("the")){
                artists.addAll(artist.getMembers().collect(Collectors.toList()));
            }else{
                artists.add(artist);
            };
        });
        return  artists.stream();
    }
}
