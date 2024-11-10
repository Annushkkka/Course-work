package org.example.programm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface MasterServiceRepository extends JpaRepository<MasterService, Integer> {
    @Query("SELECT ms FROM MasterService ms " +
            "where concat(ms.master, ms.service) LIKE %?1%")
    List<MasterService> search(String keyword);
}
