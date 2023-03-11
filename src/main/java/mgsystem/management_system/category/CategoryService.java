package mgsystem.management_system.category;

import mgsystem.management_system.product.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryService {
    @Autowired
    private CategoryRepository repo;

    /**
     * 顯示所有資料
     */
    public List<Category> AllData(){
        return repo.findAll();
    }

}
