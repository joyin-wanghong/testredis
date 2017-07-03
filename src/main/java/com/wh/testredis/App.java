package com.wh.testredis;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wh.testredis.entity.Student;
import com.wh.testredis.util.SerializeUtil;

import redis.clients.jedis.Jedis;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		// 连接本地的 Redis 服务
		Jedis jedis = new Jedis("192.168.1.110");
		System.out.println("连接成功");
		// 查看服务是否运行
		Map sss = new HashMap<byte[], byte[]>();
		Student s = new Student();
		s.setAddr("安徽合肥");
		s.setAge(324);
		s.setLl(new BigDecimal(34));
		
		sss.put("a".getBytes(), "avalue".getBytes());
		byte[] ss = SerializeUtil.serialize(s);
		
		//Student student2 = (Student)SerializeUtil.unserialize(ss);
		
		sss.put("c".getBytes(), ss);
		String  result = jedis.hmset("sss".getBytes(), sss);

		System.out.println(result);
		
		List<byte[]> lst = jedis.hmget("sss".getBytes(), "c".getBytes());
	
		byte[] bs = lst.get(0);
		
		Student student = (Student)SerializeUtil.unserialize(lst.get(0));
		System.out.print(student.getAddr());
	}

}
