package cn.leyizuo.www.redis;


import redis.clients.jedis.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class RedisClient {
    private Jedis jedis;
    private JedisPool jedisPool;
    private ShardedJedis shardedJedis;
    private ShardedJedisPool shardedJedisPool;

    public RedisClient(){
        initialPool();
        initialShardedPool();
        jedis = jedisPool.getResource();
        shardedJedis = shardedJedisPool.getResource();

    }

    private void initialPool() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(20);
        config.setMaxIdle(5);
        config.setMaxWaitMillis(1000000);
        config.setTestOnBorrow(false);
        jedisPool = new JedisPool(config,"127.0.0.1",6379);
    }

    private void initialShardedPool() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(20);
        config.setMaxWaitMillis(1000000);
        config.setTestOnBorrow(false);
        config.setMaxIdle(5);
        List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
        shards.add(new JedisShardInfo("127.0.0.1",6379,"master"));
        shardedJedisPool = new ShardedJedisPool(config,shards);
    }

    public void show(){
        //keyOperate();
        //stringOperate();
        //listOperate();
        //setOperate();
        //sortedSetOperate();
        hashOperate();
        jedisPool.close();
        shardedJedisPool.close();
    }

    private void hashOperate() {
        System.out.println("======================测试hashSet=========================================");
        System.out.println("清理redis缓存："+jedis.flushDB());
        System.out.println("添加hashset内容keyvalue："+shardedJedis.hset("hs","key001","value001"));
        System.out.println("添加hashset内容keyvalue："+shardedJedis.hset("hs","key002","value002"));
        System.out.println("添加hashset内容keyvalue："+shardedJedis.hset("hs","key003","value003"));
        System.out.println("添加hashset内容keyvalue："+shardedJedis.hset("hs","key004","value004"));
        System.out.println("添加hashset内容keyvalue："+shardedJedis.hset("hs","key005","value005"));
        System.out.println("添加hashset内容整数值："+shardedJedis.hincrBy("hs","key006",006));
        System.out.println("显示hashset全部内容："+jedis.hvals("hs"));
        System.out.println("删除hashset某个数值"+jedis.hdel("hs","key006"));
        System.out.println("显示全部内容："+jedis.hvals("hs"));
        System.out.println("是否存在："+jedis.hexists("hs","key006"));
        System.out.println("获取对应的值:"+jedis.hget("hs","key005"));
        System.out.println("获取所有的key："+jedis.hkeys("hs"));
        System.out.println("获取所有的值:"+jedis.hvals("hs"));



    }

    private void sortedSetOperate() {
        System.out.println("======================测试SortedSet=========================================");
        System.out.println("清理redis缓存:"+jedis.flushDB());
        System.out.println("添加排序集合内容:"+ shardedJedis.zadd("ss",1.0,"element1"));
        System.out.println("添加排序集合内容:"+ shardedJedis.zadd("ss",2.0,"element2"));
        System.out.println("添加排序集合内容:"+ shardedJedis.zadd("ss",3.0,"element3"));
        System.out.println("添加排序集合内容:"+ shardedJedis.zadd("ss",4.0,"element4"));
        System.out.println("添加排序集合内容:"+ shardedJedis.zadd("ss",5.0,"element5"));
        System.out.println("添加排序集合内容:"+ shardedJedis.zadd("ss",6.0,"element6"));
        System.out.println("添加排序集合内容:"+ shardedJedis.zadd("ss",4.5,"element7"));
        System.out.println("展示排序集合:"+ jedis.zrange("ss",0,-1));
        System.out.println("删除元素:"+jedis.zrem("ss","element1"));
        System.out.println("展示排序集合:"+ jedis.zrange("ss",0,-1));
        System.out.println("展示排序集合内元素个数："+jedis.zcard("ss"));//统计元素个数
        System.out.println("展示排序集合权重范围内元素:"+jedis.zcount("ss",4,6));
        System.out.println("展示元素权重:"+jedis.zscore("ss","element7"));
        System.out.println("展示指定下表范围内元素:"+jedis.zrange("ss",2,6));

    }

    private void setOperate() {
        System.out.println("=======================对set进行操作==========================================");
        System.out.println("清理redis缓存："+ jedis.flushDB());
        System.out.println("添加集合内容"+jedis.sadd("s1","element1"));
        System.out.println("添加集合内容"+jedis.sadd("s1","element2"));
        System.out.println("添加集合内容"+jedis.sadd("s1","element3"));
        System.out.println("添加集合内容"+jedis.sadd("s1","element4"));
        System.out.println("添加集合内容"+jedis.sadd("s1","element6"));
        System.out.println("添加集合内容"+jedis.sadd("s2","element3"));
        System.out.println("添加集合内容"+jedis.sadd("s2","element4"));
        System.out.println("添加集合内容"+jedis.sadd("s2","element5"));
        System.out.println("添加集合内容"+jedis.sadd("s2","element6"));
        System.out.println("添加集合内容"+jedis.sadd("s2","element7"));
        System.out.println("添加集合内容"+jedis.sadd("s2","element8"));
        System.out.println("展示集合内容："+jedis.smembers("s1"));
        System.out.println("展示集合内容："+jedis.smembers("s2"));
        System.out.println("删除元素:" +shardedJedis.srem("s1","element2"));
        System.out.println("展示集合所有内容:" +jedis.smembers("s1"));
        System.out.println("是否存在集合内:"+jedis.sismember("s1","element2"));
        Set<String> valueSet = jedis.smembers("s1");//原来这返回是一个集合;
        Iterator<String> iterator = valueSet.iterator();
        while(iterator.hasNext()){
            Object object = iterator.next();
            System.out.println(object);
        }
        System.out.println("查看交集："+jedis.sinter("s1","s2"));
        System.out.println("查看并集:"+jedis.sunion("s1","s2"));
        System.out.println("展示集合所有内容:" +jedis.smembers("s1"));
        System.out.println("展示集合所有内容:" +jedis.smembers("s2"));
        System.out.println("查看差集："+jedis.sdiff("s1","s2"));//s1中存在，s2中没有的
        System.out.println("查看差集："+jedis.sdiff("s2","s1"));


    }

    private void listOperate() {
        System.out.println("===========================对list进行操作============================================");
        System.out.println("清理redis缓存"+jedis.flushDB());
        System.out.println("添加两个list");
        System.out.println("添加list数据"+shardedJedis.lpush("StringList","vector"));
        System.out.println("添加list数据"+shardedJedis.lpush("StringList","vector"));
        System.out.println("添加list数据"+shardedJedis.lpush("StringList","arraylist"));
        System.out.println("添加list数据"+shardedJedis.lpush("StringList","vector"));
        System.out.println("添加list数据"+shardedJedis.lpush("StringList","linkedlist"));
        System.out.println("添加list数据"+shardedJedis.lpush("StringList","maplist"));
        System.out.println("添加list数据"+shardedJedis.lpush("StringList","seriallist"));
        System.out.println("添加list数据"+shardedJedis.lpush("StringList","hashlist"));
        System.out.println("添加list数据"+shardedJedis.lpush("numberList","1"));
        System.out.println("添加list数据"+shardedJedis.lpush("numberList","2"));
        System.out.println("添加list数据"+shardedJedis.lpush("numberList","3"));
        System.out.println("添加list数据"+shardedJedis.lpush("StringList","4"));
        System.out.println("展示字符list:"+shardedJedis.lrange("StringList",0,-1));
        System.out.println("展示数字list:"+shardedJedis.lrange("numberList",0,-1));
        System.out.println("删除指定value,指定个数以先进后出的栈规则："+shardedJedis.lrem("StringList",2,"vector"));
        System.out.println("展示字符list:"+shardedJedis.lrange("StringList",0,-1));
        System.out.println("删除个数超过存在个人:"+shardedJedis.lrem("numberList",3,"1")); //也可以删除
        System.out.println("展示数字list:"+shardedJedis.lrange("numberList",0,-1));
        System.out.println("删除除指定位置区间的所有成员："+shardedJedis.ltrim("StringList",2,6));
        System.out.println("展示所有成员："+shardedJedis.lrange("StringList",0,-1));
        System.out.println("出栈："+shardedJedis.lpop("StringList"));  //出栈只出一个
        System.out.println("展示所有成员："+shardedJedis.lrange("StringList",0,-1));
        System.out.println("修改下标:"+shardedJedis.lset("StringList",2,"updateString"));
        System.out.println("展示所有成员："+shardedJedis.lrange("StringList",0,-1));
        System.out.println("展示长度:"+shardedJedis.llen("StringList"));
        SortingParams sortingParams = new SortingParams();
        sortingParams.alpha();
        sortingParams.limit(0,3); //排序的起始位置，排序的个数
        System.out.println("对字符串list进行排序："+shardedJedis.sort("StringList",sortingParams));
        System.out.println("对数字list进行排序：" +shardedJedis.sort("numberList",sortingParams));
        System.out.println("返回指定位置的子字符串:"+shardedJedis.lrange("numberList",2,-1));
        System.out.println("获取指定位置的value："+shardedJedis.lindex("StringList",2));

    }

    private void stringOperate() {
        System.out.println("=====================对String进行操作===================================");
        System.out.println("清空redis管理缓存"+jedis.flushDB());
        System.out.println("不存在新建"+shardedJedis.setnx("0001","1111"));
        System.out.println("存在不改变"+shardedJedis.setnx("0001","1112"));
        System.out.println("不存在新建,存在不改变"+shardedJedis.setnx("0002","2222"));
        System.out.println("0001的值"+shardedJedis.get("0001"));
        System.out.println("0002的值"+shardedJedis.get("0002"));
        System.out.println("设置有效期，过期为新值"+shardedJedis.setex("0003",2,"33333"));
        System.out.println("0003的值"+shardedJedis.get("0003"));
        try{
            Thread.sleep(3000);
        }catch(InterruptedException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("0003的值："+shardedJedis.get("0003"));
        System.out.println("获取原值设置新值："+shardedJedis.getSet("0003","333342345345"));
        System.out.println("获取原值的字串："+shardedJedis.getrange("0003",4,8));
        System.out.println("原值续写："+shardedJedis.append("0003","99999"));
        System.out.println("获取0003："+shardedJedis.get("0003"));

    }

    private void keyOperate() {
        System.out.println("==================对Key进行操作常见命令=====================");
        System.out.println("清空所有redis管理缓存："+jedis.flushDB());
        System.out.println("是否存在key："+shardedJedis.exists("001"));
        System.out.println("设置key，value："+shardedJedis.set("001","111"));
        System.out.println("是否存在key："+shardedJedis.exists("001"));
        System.out.println("设置key，value："+shardedJedis.set("002","222"));
        System.out.println("系统中如下键,值");
        Set<String> keys = jedis.keys("*");
        Iterator<String> iterator = keys.iterator();
        //为什么只返回0001key，因为使用了if执行了一遍
        while(iterator.hasNext()){
            String key = iterator.next();
            String value =jedis.get(key);
            System.out.println("键："+key+"值:"+value);
        }
        System.out.println("删除存在Key："+shardedJedis.del("002"));
        System.out.println("删除不存在Key会有什么效果："+shardedJedis.del("003"));
        //System.out.println("设置过期时间："+shardedJedis.expire("001",5));
        System.out.println("设置key，value"+shardedJedis.set("004","444"));
        System.out.println("设置key，value"+shardedJedis.set("005","555"));
        try{
            Thread.sleep(10000);
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        Set<String> rediskeys = jedis.keys("*");
        Iterator<String> redisiterator = rediskeys.iterator();
        //下面语句根本没有执行，不能使用原lterator，新建一个lterator也只是显示新增内容,而且到这里就会卡住
        while(redisiterator.hasNext()){
            String key = redisiterator.next();
            String value =jedis.get(key);
            System.out.println("键："+key+"值:"+value);
        }
        System.out.println("重新设置002"+shardedJedis.setex("002",7,"2223"));
        System.out.println("查看剩余生存时间"+shardedJedis.ttl("002"));
        System.out.println("是否存在001"+shardedJedis.exists("001")); //为什么会不存在了，因为之前对001设置生存期
        System.out.println("设置过期时间"+shardedJedis.expire("001",5));
        System.out.println("查看剩余生存时间"+shardedJedis.ttl("001"));
        System.out.println("持久化key"+shardedJedis.persist("002"));
        System.out.println("查看剩余生存时间"+shardedJedis.ttl("002")); //持久化就不能查看剩余时间
        System.out.println("查看存储值类型"+shardedJedis.type("002"));
        //可以移库
    }


}
