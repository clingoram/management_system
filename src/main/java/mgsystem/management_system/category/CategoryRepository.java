package mgsystem.management_system.category;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    // Read
    @Query(value = "SELECT c.id,c.name FROM category AS c;", nativeQuery = true)
    // 將資料存放進一個List回傳
    public List<Category> AllData();

    // Read
    @Query(value = "SELECT id,name FROM category WHERE id = :id", nativeQuery = true)
    public String getOne(@Param("id") long id);

    // Insert
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO category(name, create_time) VALUES (:name, :now);", nativeQuery = true)
    public void addData(@Param("name") String name, @Param("now")Date now);

    // Update
    @Transactional
    @Modifying
    @Query(value = "UPDATE category SET name =:name WHERE id= :id", nativeQuery = true)
    public void modify(@Param("id") long id, @Param("name") String name);

    // Delete
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM category WHERE id = :id", nativeQuery = true)
    public void remove(@Param("id") long id);
}
