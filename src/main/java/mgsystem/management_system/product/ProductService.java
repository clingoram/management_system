package mgsystem.management_system.product;

// service/business layer

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    // CRUD
    @Autowired
    private ProductRepository repo;

    /**
     * 顯示所有資料
     *
     * @return
     */
    public List<Product> listAllData(){
        return repo.findAll();
    }

    /**
     * 儲存資料
     *
     * @param product
     */
    public void save(Product product){
        repo.save(product);
    }


    /**
     * 取得單一資料
     *
     * @param id
     * @return
     */
    public Product get(long id){
        return repo.findById(id).get();

//        Optional <Product> optional = repo.findById(id);
//        Product product = null;
//        if (optional.isPresent()) {
//            product = optional.get();
//        } else {
//            throw new RuntimeException("Product not found for id :: " + id);
//        }
//        return product;
    }

    /**
     * 刪除單一資料
     *
     * @param id
     */
//    public void delete(long id){
//        repo.deleteById(id);
//    }

    // ---------------
    // call repo methods.
    /**
     * 顯示所有資料
     */
//    public List<Product> listAllData(){
//        return repo.findAll();
//    }

    public String getOneData(long id){
        return repo.getOne(id);
    }
    /**
      *  新增資料
     * @param name String
     * @param price float
     */
    public void insert(String name,float price){
        repo.addData(name,price);
    }

    /**
     * 更新資料
     * @param id long
     * @param name String
     * @param price float
     */
    public int update(long id,String name,float price){
        return repo.modify(id,name,price);
    }

    /**
     * 刪除單一資料
     * @param id long
     */
    public int delete(long id){
        return repo.remove(id);
    }

}
