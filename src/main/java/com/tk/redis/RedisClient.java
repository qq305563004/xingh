package com.tk.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
 
@Component("redisClient")
public class RedisClient {
 
    @Autowired
	private JedisPool jedisPool;
	
	public void hset(String key, String field, String value) throws Exception{
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.hset(key, field, value);
		} finally {
			//返还到连接池
			if(jedis != null){
				 jedisPool.returnResource(jedis);
			}
		}
	}
	
	public String hget(String key, String field) throws Exception  {
 
		Jedis jedis = null;
		String data;
		try {
			jedis = jedisPool.getResource();
			data =  jedis.hget(key, field);
		} finally {
			//返还到连接池
			if(jedis != null){
				 jedisPool.returnResource(jedis);
			}			
		}
		return data;
	}
	
}
