package mgsystem.management_system.category;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CategoryService {
    @Autowired
    private CategoryRepository repo;

    /**
     * 顯示所有資料
     */
    public List<Category> AllCategoryData(){
        return repo.AllData();
    }

}
