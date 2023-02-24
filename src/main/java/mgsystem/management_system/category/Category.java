package mgsystem.management_system.category;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import mgsystem.management_system.product.Product;
import org.hibernate.mapping.Set;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Table(name="category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    Date createTime = new Date();

//    @JsonManagedReference
//    @OneToMany(cascade = CascadeType.ALL,mappedBy = "product")
//    private Set products;

    public Category(){}

    public Category(long id,String name){
        this.id = id;
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
