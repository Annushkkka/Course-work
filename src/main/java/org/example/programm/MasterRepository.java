package org.example.programm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface MasterRepository extends JpaRepository<Master, Integer> {
    @Query("SELECT m FROM Master m " +
            "where concat(m.id, m.firstName, m.lastName, m.middleName, " +
            "m.birthDate, m.phone, m.email, m.category) LIKE %?1%")
    List<Master> search(String keyword);
}
