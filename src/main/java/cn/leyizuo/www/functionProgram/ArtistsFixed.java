package cn.leyizuo.www.functionProgram;

import cn.leyizuo.www.entity.Artist;

import java.util.List;
import java.util.Optional;

public class ArtistsFixed {
    private List<Artist> artists;

    public ArtistsFixed(List<Artist> artists){
        this.artists=artists;
    }

    public Optional<Artist> getArtist(int index){
        //Optional has private access 意思不能实例化，直接使用
        if(index<0 || index>artists.size()){
            return Optional.empty();
        }else{
            Artist artist=artists.get(index);
            return  Optional.of(artist);
        }
    }

    public Artist getArtistNo(int index){
        if(index <0|| index>artists.size()){
            throw new IllegalArgumentException("没有此索引的内容");
            //为什么 throw new IllegalAccessException报错，不能捕获此一场
        }else{
            return artists.get(index);
        }
    }
//
//    public String getArtistName(int index){
//        String name="";
//        try{
//            Artist artist=getArtist(index);
//            name = artist.getName();
//            return  name;
//        }catch(IllegalArgumentException iae){
//            iae.fillInStackTrace();
//        }finally {
//            return  name;
//        }
//    }
    public  String getArtistName(int index){
        Optional<Artist> artist = getArtist(index);
        return artist.map(Artist::getName).orElse("UnKnow");
    }
}
