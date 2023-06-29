package mgsystem.management_system.order;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import mgsystem.management_system.product.Product;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPooled;

import java.util.HashMap;
import java.util.Map;

//@Entity
//@Table(name = "order")

//public class Order {
//
//    @Id
//    @GeneratedValue
//    private long id;
//
//    @JsonBackReference
//    @ManyToOne(cascade = CascadeType.ALL,targetEntity = Product.class)
//    @JoinColumn(name = "product_id",columnDefinition = "jsonb")
//    private Product product;
//
//    @Column(name="cost")
//    private  int cost;
//
//    @Column(name="note")
//    private String note;
//
//    public Order(){
//    }
//
//    public Order(long id,int cost,String note){
//        this.id = id;
//        this.cost = cost;
//        this.note = note;
//    }
////
////    public setCost(){
////
////    }
////    public getCost(){
////
////    }
//}
