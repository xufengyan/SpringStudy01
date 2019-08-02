package web.test.redisTest.redisUtils;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by Administrator on 2019/6/29 0029.
 */
public class JedisPoolTest {


    private static JedisPool pool;

    //创建jedisPool对象
    public static JedisPool open(String ip,int port){

        if(pool==null){
            //创建jedispoolConfig对象，给jedisPoolconfig设置参数
            JedisPoolConfig config=new JedisPoolConfig();

            //设置连接池最大连接数
            config.setMaxTotal(20);
            //设置最大空闲数
            config.setMaxIdle(2);
            //设置检查项为true ，表示线程次池中获取的对象是检查可用的
            config.setTestOnBorrow(true);

            //创建pool对象
            pool=new JedisPool(config,ip,port,6000,"123456");
        }
        return pool;
    }

    public static void close(){

        if(pool!=null){
            pool.close();
        }


    }


}
