package mgsystem.management_system.product;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {

    // Read
    @Query(value = "SELECT id,name,price FROM product;", nativeQuery = true)
    // 將資料存放進一個List回傳
    public List<Product> listAllData();


    // Read
    @Query(value = "SELECT id,name,price FROM product WHERE id = :id", nativeQuery = true)
    public String getOne(@Param("id") long id);

    // Insert
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO product(name, price) VALUES (:name, :price);", nativeQuery = true)
    public void addData(@Param("name") String name, @Param("price") Integer price);

    // Update
    @Transactional
    @Modifying
    @Query(value = "UPDATE product SET name =:name,price =:price WHERE id= :id", nativeQuery = true)
    public void modify(@Param("id") long id, @Param("name") String name, @Param("price") Integer price);

    // Delete
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM product WHERE id = :id", nativeQuery = true)
    public void remove(@Param("id") long id);
}
