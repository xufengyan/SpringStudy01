package web.test.redisTest;

import io.netty.channel.nio.NioEventLoop;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import web.test.redisTest.redisUtils.JedisPoolTest;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019/6/28 0028.
 */
public class redisJedis {

    public static void main(String [] args){

//        ByteBuffer buffer=ByteBuffer.allocate(4);
//
//        System.out.println(String.format("c:%s,p:%s,l:%s",buffer.capacity(),buffer.position(),buffer.limit()));
//
//        buffer.put((byte) 1);
//        buffer.put((byte) 1);
//        buffer.put((byte) 1);
//
//        System.out.println(String.format("c:%s,p:%s,l:%s",buffer.capacity(),buffer.position(),buffer.limit()));
        JedisPool pool=null;
        Jedis jedis =null;
        try {
            pool= JedisPoolTest.open("127.0.0.1",6379);

            Map map =new HashMap();

            map.put("name","小白");
            map.put("age","36");

            jedis=pool.getResource();

            jedis.hmset("student",map);

            System.out.println("Map:"+jedis.hmget("student","name","age"));

            System.out.println(jedis.set("k2","asdasda撒大大"));

            System.out.println( jedis.ping());

            System.out.println( jedis.keys("*"));

            if(!"".equals(jedis.get("k2"))){

                jedis.set("k2","弘基吃了没事干adfasdasdasdas");
                System.out.println(jedis.get("kk"));
                System.out.println(jedis.get("k2"));
            }else {

                System.out.println(jedis.get("k2"));

            }

        }finally {

            JedisPoolTest.close();

        }




    }


}
