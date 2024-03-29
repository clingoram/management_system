package mgsystem.management_system.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import mgsystem.management_system.category.Category;

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

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL,targetEntity = Category.class)
    @JoinColumn(name = "category_id")
    private Category category;

//    private int order_number;

    // Constructor 1(JPA預設).
    public Product(){

    }

    // Constructor 2(用來建立跟資料庫有關的資料表相關欄位等資料)
    public Product(Long id,String name,Integer price,Category cid) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = cid;
//        this.order_number = orderNumber;
    }

    public Product(String name) {
        this.name = name;
    }
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
    public void setCategory(Category cid){
        this.category = cid;
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
    public Category getCategory(){
        return this.category;
    }

//    public int getOrder_number(){
//        return order_number;
//    }

    @Override
    public String toString(){
        return "Product {" + "id = " + id +", name = " + name +",price= "+ price +"}";
    }
}
