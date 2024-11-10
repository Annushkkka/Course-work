package org.example.programm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ClientRepository extends JpaRepository<Master, Integer> {
    @Query("SELECT c FROM Client c " +
            "where concat(c.id, c.firstName, c.lastName, c.middleName, " +
            "c.birthDate, c.phone, c.email) LIKE %?1%")
    List<Master> search(String keyword);
}
