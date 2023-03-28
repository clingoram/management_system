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

    @Column(name = "eName")
    private String englishName;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    Date createTime = new Date();

//    @JsonManagedReference
//    @OneToMany(cascade = CascadeType.ALL,mappedBy = "product")
//    private Set products;

    public Category(){}

    public Category(long id,String name,String english_name){
        this.id = id;
        this.name = name;
        this.englishName = english_name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCategory(String name,String english_name) {
        this.name = name;
        this.englishName = english_name;
    }

    public long getId() {
        return this.id;
    }

    public String getCategory() {
        return this.name;
    }
}
