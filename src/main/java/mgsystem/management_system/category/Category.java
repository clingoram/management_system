package mgsystem.management_system.category;

import jakarta.persistence.Column;

public class Category {

    private long id;
    @Column(name = "name")
    private String name;

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
