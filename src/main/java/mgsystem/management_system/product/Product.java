package mgsystem.management_system.product;

import jakarta.persistence.*;

import java.math.BigDecimal;

// Model
// Create table.
@Entity
@Table(name="product")
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )

    // property
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Integer price;

//    @OneToMany(cascade = CascadeType.ALL)
//    private Long category_id;
//    @JoinColumn(name = "category_id")

//    private int order_number;

    // Constructor 1(JPA預設).
    public Product(){

    }

    // Constructor 2(用來建立跟資料庫有關的資料表相關欄位等資料)
    public Product(Long id,String name,Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
//        this.order_number = orderNumber;
//        this.category_id = category_id;
    }

    public Product(String name) {
        this.name = name;
    }

    // Getter
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice(){
//        return new BigDecimal(price);
        return this.price;
    }

//    public int getOrder_number(){
//        return order_number;
//    }

    // Setter
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

//    public void setOrder_number(int orderNumber){
//        this.order_number = orderNumber;
//    }

    @Override
    public String toString(){
        return
                "Product {" + "id = " + id +", name = " + name +",price= "+ price +"}";
    }
}
