package org.example.programm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query("SELECT c FROM Category c " +
            "where concat(c.id, c.name, c.priceMultiplier) LIKE %?1%")
    List<Category> search(String keyword);
}
