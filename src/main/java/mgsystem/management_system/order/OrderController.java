//package mgsystem.management_system.order;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisPool;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Controller
////@RestController
//@RequestMapping("/api")
//public class OrderController {
//    JedisPool pool = new JedisPool("localhost", 6379);
//
//    @PostMapping("/new_order")
//    public void store(){
////        try {
////            Jedis jedis = pool.getResource();
////
////            Map<String, String> hash = new HashMap<>();;
////            hash.put("name", "John");
////            hash.put("surname", "Smith");
////            hash.put("company", "Redis");
////            hash.put("age", "29");
////            jedis.hset("user-session:123", hash);
////            System.out.println(jedis.hgetAll("user-session:123"));
////            // Prints: {name=John, surname=Smith, company=Redis, age=29}
////
////        }catch (Exception er){
////            System.out.println("Something wrong in Redis.");
////        }
//    }
//}
