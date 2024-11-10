package org.example.programm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ServiceRepository extends JpaRepository<Master, Integer> {
    @Query("SELECT s FROM Service s " +
            "where concat(s.id, s.name, s.basePrice, s.durationMinutes) LIKE %?1%")
    List<Master> search(String keyword);
}
